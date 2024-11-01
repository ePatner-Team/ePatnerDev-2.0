package com.orderTracking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "tracking_id", nullable = false)
    private OrderTrackingEntity orderTracking;

    @Column(nullable = false)
    private String deliveryPersonnel;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private LocalDateTime assignedTime;

    @Column
    private LocalDateTime deliveredTime;

    @Column(nullable = false)
    private String status;

    // Getters and Setters
    // Standard getters and setters for all fields
}