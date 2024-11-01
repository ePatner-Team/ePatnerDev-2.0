package com.inventoryManagement.dto;

import java.util.Date;

public class BatchAdjustmentDTO {

    private Long id;
    private Long batchId; // Referencing the batch ID
    private int adjustmentQuantity;
    private String adjustmentReason;
    private Date adjustmentDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
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
}
