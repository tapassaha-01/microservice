package com.microservice.Invertoryservice.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private boolean isInStock;


}
