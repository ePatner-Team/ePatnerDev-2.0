package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "batch")
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNumber;

    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public InventoryEntity getProduct() {
        return product;
    }

    public void setProduct(InventoryEntity product) {
        this.product = product;
    }
}
