package com.microservice.Productservice.Service;

import java.util.List;

import com.microservice.Productservice.Dto.ProductRequest;
import com.microservice.Productservice.Dto.ProductResponse;

public interface ProductService {

	boolean create(ProductRequest productReq);

	List<ProductResponse> getAll();

}
