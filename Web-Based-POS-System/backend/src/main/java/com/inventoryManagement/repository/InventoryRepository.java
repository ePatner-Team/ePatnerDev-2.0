package com.inventoryManagement.repository;

import com.inventoryManagement.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    // Custom query to find products with stock level less than a threshold
    List<InventoryEntity> findByStockLevelLessThan(int threshold);

    // Add other custom queries as needed (e.g., filtering by warehouse or category)
}
