package com.inventoryManagement.repository;

import com.inventoryManagement.entity.CycleCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleCountRepository extends JpaRepository<CycleCountEntity, Long> {
    // Custom query methods can be added if necessary
}
