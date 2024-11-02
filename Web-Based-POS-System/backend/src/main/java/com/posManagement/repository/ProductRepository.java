package com.posManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.posManagement.entity.Product;

import java.util.List;

// Repository for Product entity
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query method to find products by name (case-insensitive)
    List<Product> findByNameIgnoreCase(String name);

    // Custom query method to find products by price range
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Custom query method to find products with quantity less than a specified
    // value
    List<Product> findByQuantityLessThan(int quantity);

    // Custom query to find products by partial name match using JPQL
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> searchByName(@Param("name") String name);

}