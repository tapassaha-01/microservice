package com.microservice.Invertoryservice.Service;

import com.microservice.Invertoryservice.Entity.Inventory;
import com.microservice.Invertoryservice.Entity.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.Invertoryservice.Repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepo;

	@Transactional(readOnly = true)
	public List<InventoryResponse> isInstock(List<String> skuCodeList) {
		List<Inventory> invList= inventoryRepo.findBySkuCodeIn(skuCodeList);
//		invList.forEach(inventory -> System.out.println(inventory.getQuantity()));
		return invList.stream().map(
				inventory -> InventoryResponse.builder()
						.id(inventory.getId())
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity()>0)
						.build()
		).toList();


	}
	
}
