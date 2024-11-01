package com.inventoryManagement.repository;

import com.inventoryManagement.entity.StockAlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockAlertRepository extends JpaRepository<StockAlertEntity, Long> {
    // Add custom query methods as needed
}
