package com.inventoryManagement.repository;

import com.inventoryManagement.entity.BatchAdjustmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchAdjustmentRepository extends JpaRepository<BatchAdjustmentEntity, Long> {
    // Find batch adjustments by batch ID and optional date range
    List<BatchAdjustmentEntity> findByBatchIdAndDateRange(Long batchId, String startDate, String endDate);
}
