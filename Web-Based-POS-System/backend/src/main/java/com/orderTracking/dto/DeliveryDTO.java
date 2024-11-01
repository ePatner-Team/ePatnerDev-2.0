package com.orderTracking.dto;

import java.time.LocalDateTime;

public class DeliveryDTO {
    private Long id;
    private Long trackingId;
    private String deliveryPersonnel;
    private String contactNumber;
    private String deliveryAddress;
    private LocalDateTime assignedTime;
    private LocalDateTime deliveredTime;
    private String status;

    // Constructors
    public DeliveryDTO() {}

    public DeliveryDTO(Long id, Long trackingId, String deliveryPersonnel, String contactNumber, 
                       String deliveryAddress, LocalDateTime assignedTime, 
                       LocalDateTime deliveredTime, String status) {
        this.id = id;
        this.trackingId = trackingId;
        this.deliveryPersonnel = deliveryPersonnel;
        this.contactNumber = contactNumber;
        this.deliveryAddress = deliveryAddress;
        this.assignedTime = assignedTime;
        this.deliveredTime = deliveredTime;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTrackingId() { return trackingId; }
    public void setTrackingId(Long trackingId) { this.trackingId = trackingId; }

    public String getDeliveryPersonnel() { return deliveryPersonnel; }
    public void setDeliveryPersonnel(String deliveryPersonnel) { this.deliveryPersonnel = deliveryPersonnel; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public LocalDateTime getAssignedTime() { return assignedTime; }
    public void setAssignedTime(LocalDateTime assignedTime) { this.assignedTime = assignedTime; }

    public LocalDateTime getDeliveredTime() { return deliveredTime; }
    public void setDeliveredTime(LocalDateTime deliveredTime) { this.deliveredTime = deliveredTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
