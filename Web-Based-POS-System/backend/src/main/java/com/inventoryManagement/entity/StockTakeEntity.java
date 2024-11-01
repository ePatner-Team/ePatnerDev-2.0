package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_take")
public class StockTakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stockLevel;

    private Date stockTakeDate;

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

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Date getStockTakeDate() {
        return stockTakeDate;
    }

    public void setStockTakeDate(Date stockTakeDate) {
        this.stockTakeDate = stockTakeDate;
    }

    public InventoryEntity getProduct() {
        return product;
    }

    public void setProduct(InventoryEntity product) {
        this.product = product;
    }
}
