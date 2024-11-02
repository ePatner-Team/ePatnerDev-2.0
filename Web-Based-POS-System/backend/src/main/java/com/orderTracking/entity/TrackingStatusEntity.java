package com.orderTracking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tracking_status_history")
public class TrackingStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tracking_id", nullable = false)
    private OrderTrackingEntity orderTracking;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column
    private String description;

    @Column
    private String location;

    // Getters and Setters
    // Standard getters and setters for all fields
}
