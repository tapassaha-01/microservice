package com.microservice.Productservice.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.Productservice.Dto.ProductRequest;
import com.microservice.Productservice.Dto.ProductResponse;
import com.microservice.Productservice.Entity.Product;
import com.microservice.Productservice.Repository.ProductRepository;
import com.microservice.Productservice.Service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public boolean create(ProductRequest productReq) {
		if (productReq != null) {
			Product product = Product.builder().name(productReq.getName()).description(productReq.getDescription())
					.price(productReq.getPrice()).build();
			if (productRepo.save(product) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<ProductResponse> getAll() {
		List<Product> productLst = productRepo.findAll();
		List<ProductResponse>responseLst = productLst.stream().map(e -> new ProductResponse().builder().id(e.getId()).name(e.getName())
				.description(e.getDescription()).price(e.getPrice()).build()).toList();
		if(responseLst.isEmpty()) {
			return null;
		}
		else {
			return responseLst;
		}
	}

}
