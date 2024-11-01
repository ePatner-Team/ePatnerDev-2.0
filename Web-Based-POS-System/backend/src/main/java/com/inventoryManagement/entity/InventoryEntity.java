package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sku;

    private int stockLevel;

    private Double price;

    // Relationship to Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    // Relationship to Warehouse
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;

    // Batches related to this product
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<BatchEntity> batches;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }

    public Set<BatchEntity> getBatches() {
        return batches;
    }

    public void setBatches(Set<BatchEntity> batches) {
        this.batches = batches;
    }
}
