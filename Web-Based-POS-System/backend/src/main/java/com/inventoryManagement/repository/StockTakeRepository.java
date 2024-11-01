package com.inventoryManagement.repository;

import com.inventoryManagement.entity.StockTakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTakeRepository extends JpaRepository<StockTakeEntity, Long> {
    // Custom query methods can be added if necessary
}
