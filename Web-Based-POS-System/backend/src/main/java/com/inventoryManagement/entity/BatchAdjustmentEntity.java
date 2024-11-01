package com.inventoryManagement.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "batch_adjustment")
public class BatchAdjustmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int adjustmentQuantity;

    private String adjustmentReason;

    private Date adjustmentDate;

    // Relationship to Batch
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAdjustmentQuantity() {
        return adjustmentQuantity;
    }

    public void setAdjustmentQuantity(int adjustmentQuantity) {
        this.adjustmentQuantity = adjustmentQuantity;
    }

    public String getAdjustmentReason() {
        return adjustmentReason;
    }

    public void setAdjustmentReason(String adjustmentReason) {
        this.adjustmentReason = adjustmentReason;
    }

    public Date getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(Date adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }

    public BatchEntity getBatch() {
        return batch;
    }

    public void setBatch(BatchEntity batch) {
        this.batch = batch;
    }
}
