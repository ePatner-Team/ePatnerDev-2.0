package com.inventoryManagement.repository;

import com.inventoryManagement.entity.ProductMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovementEntity, Long> {
    // Find product movements by product ID (and optionally filter by warehouse or
    // date range)
    List<ProductMovementEntity> findByProductId(Long productId);

    // Add custom query methods as needed, e.g., for date ranges or filtering by
    // warehouse
}
