package com.inventoryManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stock_alert")
public class StockAlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int alertThreshold;

    // Relationship to Inventory (product)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private InventoryEntity product;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAlertThreshold() {
        return alertThreshold;
    }

    public void setAlertThreshold(int alertThreshold) {
        this.alertThreshold = alertThreshold;
    }

    public InventoryEntity getProduct() {
        return product;
    }

    public void setProduct(InventoryEntity product) {
        this.product = product;
    }
}
