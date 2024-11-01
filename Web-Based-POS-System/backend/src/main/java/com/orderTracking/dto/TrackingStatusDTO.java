package com.orderTracking.dto;

import java.time.LocalDateTime;

public class TrackingStatusDTO {
    private Long id;
    private Long trackingId;
    private String status;
    private LocalDateTime timestamp;
    private String description;
    private String location;

    // Constructors
    public TrackingStatusDTO() {}

    public TrackingStatusDTO(Long id, Long trackingId, String status, LocalDateTime timestamp, 
                             String description, String location) {
        this.id = id;
        this.trackingId = trackingId;
        this.status = status;
        this.timestamp = timestamp;
        this.description = description;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTrackingId() { return trackingId; }
    public void setTrackingId(Long trackingId) { this.trackingId = trackingId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
