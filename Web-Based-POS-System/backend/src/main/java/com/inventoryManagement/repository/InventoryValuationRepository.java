package com.inventoryManagement.repository;

import com.inventoryManagement.entity.InventoryValuationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryValuationRepository extends JpaRepository<InventoryValuationEntity, Long> {
    // Add custom query methods as needed
}
