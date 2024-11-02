package com.posManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.posManagement.entity.Invoice;

// Repository for Invoice entity
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // Custom query method to find invoices by customer ID
    List<Invoice> findByCustomerId(String customerId);

    // Custom query method to find invoices by total amount range
    List<Invoice> findByTotalAmountBetween(double minAmount, double maxAmount);

    // Custom query to find invoices by date
    List<Invoice> findByDate(String date);

    // Custom query to find invoices by customer ID and date range using JPQL
    @Query("SELECT i FROM Invoice i WHERE i.customerId = :customerId AND i.date BETWEEN :startDate AND :endDate")
    List<Invoice> findByCustomerIdAndDateRange(@Param("customerId") String customerId,
            @Param("startDate") String startDate, @Param("endDate") String endDate);

}
