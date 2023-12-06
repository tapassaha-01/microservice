package com.microservice.Invertoryservice.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.Invertoryservice.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findBySkuCode(String skuCode);

	List<Inventory> findBySkuCodeIn(List<String> skuCodeList);
}
