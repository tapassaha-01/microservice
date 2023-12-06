package com.microservice.Orderservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.Orderservice.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
