package com.mktp.poc.arch.purchasesmktp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private int idSupplier;

    @Column
    private String supplierIdentifier;

    public Supplier(int idSupplier, String supplierIdentifier) {
        this.idSupplier = idSupplier;
        this.supplierIdentifier = supplierIdentifier;
    }

    protected Supplier(){}

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierIdentifier() {
        return supplierIdentifier;
    }

    public void setSupplierIdentifier(String supplierIdentifier) {
        this.supplierIdentifier = supplierIdentifier;
    }
}
