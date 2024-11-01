package com.inventoryManagement.dto;

import java.util.Date;

public class StockTakeDTO {

    private Long id;
    private Long productId; // Referencing the product ID
    private int stockLevel;
    private Date stockTakeDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
}
