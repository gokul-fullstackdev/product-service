package com.fullstackdev.productservice.repository;

import com.fullstackdev.productservice.entity.ProductDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends CrudRepository<ProductDetails, String> {
    ProductDetails findByProductId(String productId);
}