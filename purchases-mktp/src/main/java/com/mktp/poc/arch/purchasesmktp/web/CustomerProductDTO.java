package com.mktp.poc.arch.purchasesmktp.web;

public class CustomerProductDTO {

    private String customerIdentifier;
    private String supplierIdentifier;
    private String productName;
    private String date;
    private Double quantity;

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public String getSupplierIdentifier() {
        return supplierIdentifier;
    }

    public void setSupplierIdentifier(String supplierIdentifier) {
        this.supplierIdentifier = supplierIdentifier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
