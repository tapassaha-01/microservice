package com.microservice.Orderservice.ServiceImp;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.microservice.Orderservice.Dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.Orderservice.Dto.OrderRequest;
import com.microservice.Orderservice.Dto.OrderRequestListDto;
import com.microservice.Orderservice.Entity.Order;
import com.microservice.Orderservice.Entity.OrderLineItems;
import com.microservice.Orderservice.Repository.OrderRepository;
import com.microservice.Orderservice.Service.OrderService;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private WebClient.Builder webClientBuilder;
	@Override
	public boolean placeOrder(OrderRequest orderReq) {

		if (orderReq != null) {
			Order order = new Order();
			order.setOrderNumber(UUID.randomUUID().toString());

			List<OrderLineItems> orderLineItemsList = orderReq.getOrderRequestList().stream()
					.map(this::mapToOrderLineItems).toList();


			order.setOrderLineItemsList(orderLineItemsList);
			List<String> skuCodeList = order.getOrderLineItemsList().stream().map(orderLineItems -> orderLineItems.getSkuCode()).toList();

			InventoryResponse[] responseList = webClientBuilder.build().get()
					.uri("http://inventory-service/api/inventory",
							uriBuilder -> uriBuilder.queryParam("skuCodeList",skuCodeList).build())
					.retrieve()
					.bodyToMono(InventoryResponse[].class)
					.block();

			for (InventoryResponse inventoryResponse : responseList) {
				System.out.println(inventoryResponse.isInStock());
			}

			boolean InventoryIsStockResponse = Arrays.stream(responseList).allMatch(InventoryResponse::isInStock);
//			System.out.println(skuCodeList.size());

			if (InventoryIsStockResponse) {
				orderRepo.save(order);
				return true;
			}
		}
		return false;

	}

	private OrderLineItems mapToOrderLineItems(OrderRequestListDto orderReqlist) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderReqlist.getPrice());
		orderLineItems.setSkuCode(orderReqlist.getSkuCode());
		orderLineItems.setQuantity(orderReqlist.getQuantity());
		return orderLineItems;
	}

}
