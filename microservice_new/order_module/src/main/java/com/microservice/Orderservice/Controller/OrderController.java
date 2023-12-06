package com.microservice.Orderservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Orderservice.Dto.OrderRequest;
import com.microservice.Orderservice.Service.OrderService;

@RestController
@RequestMapping("/api/order-service")
public class OrderController {

	@Autowired
	private OrderService orderService;



	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderReq) {

		if (orderService.placeOrder(orderReq)) {
			return ResponseEntity.ok().body("Order has Placed!!");
		} else {
			return ResponseEntity.ofNullable(null);
		}
	}
}
