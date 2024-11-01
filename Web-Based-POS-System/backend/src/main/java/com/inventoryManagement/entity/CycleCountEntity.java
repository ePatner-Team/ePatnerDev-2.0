package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cycle_count")
public class CycleCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int countedQuantity;

    private Date cycleDate;

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

    public int getCountedQuantity() {
        return countedQuantity;
    }

    public void setCountedQuantity(int countedQuantity) {
        this.countedQuantity = countedQuantity;
    }

    public Date getCycleDate() {
        return cycleDate;
    }

    public void setCycleDate(Date cycleDate) {
        this.cycleDate = cycleDate;
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
