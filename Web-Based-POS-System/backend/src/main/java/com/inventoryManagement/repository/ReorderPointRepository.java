package com.inventoryManagement.repository;

import com.inventoryManagement.entity.ReorderPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReorderPointRepository extends JpaRepository<ReorderPointEntity, Long> {
    // Custom query methods can be added if necessary
}
