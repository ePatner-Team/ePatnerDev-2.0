package com.posManagement.dto;

import java.util.List;

public class InvoiceRequest {
    private List<String> productIds;
    private String customerId;

    // Getters and Setters
    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
