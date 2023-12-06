package com.microservice.Productservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Productservice.Dto.ProductRequest;
import com.microservice.Productservice.Dto.ProductResponse;
import com.microservice.Productservice.Service.ProductService;

@RestController
@RequestMapping(value="/product-service")
public class ProductController {
	
	
//	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/create")
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest productReq){
		if(productService.create(productReq)) {
			return ResponseEntity
					.ok()
					.body("Created!!");
		}
		else
			return ResponseEntity.ofNullable(null);
		
	}
	
	@GetMapping(value="/getall")
	public ResponseEntity<?> getAllProducts(){
		List<ProductResponse> response =  productService.getAll();
		if(response!=null) {
			return ResponseEntity
					.ok()
					.body(response);
		}
		else
			return ResponseEntity.notFound().build();
		
	}
}
