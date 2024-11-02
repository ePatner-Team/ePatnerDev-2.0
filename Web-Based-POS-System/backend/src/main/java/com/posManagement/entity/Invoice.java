package com.posManagement.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates a unique ID for each invoice
    private Long id;

    @OneToMany // Defines a one-to-many relationship; an invoice can have multiple products
    private List<Product> products;

    @Column(nullable = false) // Ensures that the total amount cannot be null
    private double totalAmount;

    @Column(nullable = true) // Customer ID is optional, allowing for anonymous transactions
    private String customerId;

    @Column(nullable = false) // The date of the invoice cannot be null
    private String date;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
