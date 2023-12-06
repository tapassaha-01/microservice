package com.microservice.Orderservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private boolean isInStock;


}
