package com.mktp.poc.arch.purchasesmktp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int idProduct;

    @Column
    private String productName;

    @Column
    private String productDescription;

    public Product(int idProduct, String productName, String productDescription) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    protected Product(){}

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
