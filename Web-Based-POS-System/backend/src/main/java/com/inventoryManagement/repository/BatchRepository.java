package com.inventoryManagement.repository;

import com.inventoryManagement.entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Long> {
    // Find batches by product ID
    List<BatchEntity> findByProductId(Long productId);
}
