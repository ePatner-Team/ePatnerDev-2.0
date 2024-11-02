package com.orderTracking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_tracking")
public class OrderTrackingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @OneToOne(mappedBy = "orderTracking", cascade = CascadeType.ALL)
    private DeliveryEntity delivery;

    @Column(nullable = false)
    private String currentStatus;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @Column
    private LocalDateTime estimatedDeliveryTime;

    @Column
    private Boolean isActive;

    // Getters and Setters
    // Standard getters and setters for all fields
}