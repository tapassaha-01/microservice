package com.microservice.Orderservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestListDto {

	private Long id;
	private String skuCode;
	private Double price;
	private Long quantity;
	
}
