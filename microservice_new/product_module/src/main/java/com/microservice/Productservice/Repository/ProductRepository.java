package com.microservice.Productservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.Productservice.Entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
