package com.posManagement.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates a unique ID for each product
    private Long id;

    @Column(nullable = false) // Ensures that the product name cannot be null
    private String name;

    @Column(nullable = false) // Ensures that the product price cannot be null
    private double price;

    @Column(nullable = false) // Ensures that the product quantity cannot be null
    private int quantity;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}