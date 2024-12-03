package com.ms.productservice.Repository;

import com.ms.productservice.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
