package com.mktp.poc.arch.purchasesmktp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int idCustomer;

    @Column
    private String customerIdentifier;

    public Customer(int idCustomer, String customerIdentifier) {
        this.idCustomer = idCustomer;
        this.customerIdentifier = customerIdentifier;
    }

    protected Customer(){}

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

}
