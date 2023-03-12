package com.etsCaffe.productServices.repository;

import com.etsCaffe.productServices.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}