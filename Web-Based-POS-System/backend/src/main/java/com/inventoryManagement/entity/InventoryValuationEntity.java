package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventory_valuation")
public class InventoryValuationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalValue;

    private Date valuationDate;

    // Relationship to Inventory (product)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private InventoryEntity product;

    // Relationship to Warehouse
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Date getValuationDate() {
        return valuationDate;
    }

    public void setValuationDate(Date valuationDate) {
        this.valuationDate = valuationDate;
    }

    public InventoryEntity getProduct() {
        return product;
    }

    public void setProduct(InventoryEntity product) {
        this.product = product;
    }

    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }
}
