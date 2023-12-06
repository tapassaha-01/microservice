package com.microservice.Invertoryservice.Controller;

import com.microservice.Invertoryservice.Entity.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microservice.Invertoryservice.Service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService service;

	@GetMapping
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodeList) {
		return service.isInstock(skuCodeList);
	}
}
