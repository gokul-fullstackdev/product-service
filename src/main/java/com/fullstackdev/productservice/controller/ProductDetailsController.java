package com.fullstackdev.productservice.controller;

import com.fullstackdev.productservice.entity.ProductDetails;
import com.fullstackdev.productservice.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(path = "/api/v1/productservice")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    private EntityManager entityManager;

    @PostMapping(path = "/saveProductDetails", produces = "application/json")
    public ResponseEntity saveProductDetails(@RequestBody ProductDetails productDetails) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).cacheControl(CacheControl.noCache()).body(productDetailsService.saveProductDetails(productDetails));
    }

    @GetMapping(path = "/getProductDetails/{productId}", produces = "application/json")
    public ResponseEntity getProductDetails(@PathVariable("productId") String productId) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).cacheControl(CacheControl.noCache()).body(productDetailsService.findByProductId(productId));
    }

    @GetMapping(path = "/searchProductDetails", produces = "application/json")
    public ResponseEntity searchProductDetails(@RequestParam(name = "query") String searchQuery) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).cacheControl(CacheControl.noCache()).body(productDetailsService.searchProductDetails(entityManager, searchQuery));
    }

}