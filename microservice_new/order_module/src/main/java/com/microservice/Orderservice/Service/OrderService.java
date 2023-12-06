package com.microservice.Orderservice.Service;

import com.microservice.Orderservice.Dto.OrderRequest;

public interface OrderService {

	boolean placeOrder(OrderRequest orderReq);

}
