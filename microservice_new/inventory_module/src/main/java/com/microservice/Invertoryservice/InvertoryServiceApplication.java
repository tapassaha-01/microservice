package com.microservice.Invertoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.microservice.Invertoryservice.Entity.Inventory;
import com.microservice.Invertoryservice.Repository.InventoryRepository;

@SpringBootApplication
public class InvertoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvertoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepo) {
		return args->{
			Inventory inv1 = Inventory.builder()
					.skuCode("A52s")
					.quantity(2L)
					.build();
			
			Inventory inv2 = Inventory.builder()
					.skuCode("SMA72s")
					.quantity(5L)
					.build();
			
			inventoryRepo.save(inv1);
			inventoryRepo.save(inv2);
			
		};
	}

}
