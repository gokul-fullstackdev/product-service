package com.fullstackdev.productservice.service;

import com.fullstackdev.productservice.entity.ProductDetails;
import com.fullstackdev.productservice.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    public ProductDetails saveProductDetails(ProductDetails productDetails) {
        return productDetailsRepository.save(productDetails);
    }

    public ProductDetails findByProductId(String productId) {
        return productDetailsRepository.findByProductId(productId);
    }

    public List<ProductDetails> searchProductDetails(EntityManager entityManager, String searchQuery) {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        String queryStr = "SELECT * FROM product_details WHERE UPPER(product_name) REGEXP '.*" + searchQuery.toUpperCase() + ".*'";
        try {
            List list = entityManager.createNativeQuery(queryStr).getResultList();
            for (Object o : list) {
                ProductDetails productDetails = new ProductDetails((Object[]) o);
                productDetailsList.add(productDetails);
            }
            return productDetailsList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<ProductDetails>) productDetailsRepository.findAll();
    }
}