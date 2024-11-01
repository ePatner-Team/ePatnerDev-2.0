package com.inventoryManagement.repository;

import com.inventoryManagement.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // Custom query methods can be added if necessary
}
