package com.fullstackdev.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private Double productPrice;

    public ProductDetails(Object[] columns) {
        this.productId = (columns[0] != null) ? (String) columns[0] : "";
        this.productName = (columns[1] != null) ? (String) columns[1] : "";
        this.productDescription = (columns[2] != null) ? (String) columns[2] : "";
        this.productPrice = (columns[3] != null) ? (Double) columns[3] : null;
    }
}