package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Products belonging to this category
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
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

    public Set<InventoryEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<InventoryEntity> products) {
        this.products = products;
    }
}
