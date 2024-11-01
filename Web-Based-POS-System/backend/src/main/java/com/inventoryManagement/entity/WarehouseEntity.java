package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "warehouse")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    // Products stored in this warehouse
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private Set<InventoryEntity> products;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<InventoryEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<InventoryEntity> products) {
        this.products = products;
    }
}
