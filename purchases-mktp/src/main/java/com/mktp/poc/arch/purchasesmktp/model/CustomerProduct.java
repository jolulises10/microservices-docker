package com.mktp.poc.arch.purchasesmktp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerProduct {

    @Id
    @GeneratedValue
    private int idCustomerProduct;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product idProduct;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer idCustomer;

    @Column
    private Date date;

    @Column
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier idSupplier;

    public CustomerProduct(int idCustomerProduct, Product idProduct, Customer idCustomer, Date date, double quantity, Supplier idSupplier) {
        this.idCustomerProduct = idCustomerProduct;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
        this.date = date;
        this.quantity = quantity;
        this.idSupplier = idSupplier;
    }

    protected CustomerProduct(){}

    public int getIdCustomerProduct() {
        return idCustomerProduct;
    }

    public void setIdCustomerProduct(int idCustomerProduct) {
        this.idCustomerProduct = idCustomerProduct;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Supplier getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Supplier idSupplier) {
        this.idSupplier = idSupplier;
    }
}
