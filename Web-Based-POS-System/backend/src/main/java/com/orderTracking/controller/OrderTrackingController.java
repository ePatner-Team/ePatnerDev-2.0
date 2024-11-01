package com.orderTracking.controller;

import com.orderTracking.dto.OrderTrackingDTO;
import com.orderTracking.service.OrderTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-tracking")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService orderTrackingService;

    // Create a new order tracking entry
    @PostMapping
    public ResponseEntity<OrderTrackingDTO> createOrderTracking(@RequestBody OrderTrackingDTO orderTrackingDTO) {
        OrderTrackingDTO createdTracking = orderTrackingService.createOrderTracking(orderTrackingDTO);
        return ResponseEntity.ok(createdTracking);
    }

    // Get tracking information for a specific order
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderTrackingDTO> getOrderTracking(@PathVariable Long orderId) {
        OrderTrackingDTO tracking = orderTrackingService.getOrderTracking(orderId);
        return ResponseEntity.ok(tracking);
    }

    // Update order status and estimated delivery time
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderTrackingDTO> updateOrderTracking(
            @PathVariable Long orderId,
            @RequestBody OrderTrackingDTO orderTrackingDTO) {
        OrderTrackingDTO updatedTracking = orderTrackingService.updateOrderTracking(orderId, orderTrackingDTO);
        return ResponseEntity.ok(updatedTracking);
    }

    // Get all active order trackings
    @GetMapping("/active")
    public ResponseEntity<List<OrderTrackingDTO>> getActiveOrderTrackings() {
        List<OrderTrackingDTO> activeTrackings = orderTrackingService.getActiveOrderTrackings();
        return ResponseEntity.ok(activeTrackings);
    }

    // Update delivery status
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<OrderTrackingDTO> updateDeliveryStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {
        OrderTrackingDTO updatedTracking = orderTrackingService.updateDeliveryStatus(orderId, status);
        return ResponseEntity.ok(updatedTracking);
    }

    // Get estimated delivery time remaining
    @GetMapping("/{orderId}/countdown")
    public ResponseEntity<Long> getDeliveryCountdown(@PathVariable Long orderId) {
        Long timeRemaining = orderTrackingService.getDeliveryCountdown(orderId);
        return ResponseEntity.ok(timeRemaining);
    }

    // Cancel order tracking
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancelOrderTracking(@PathVariable Long orderId) {
        orderTrackingService.cancelOrderTracking(orderId);
        return ResponseEntity.noContent().build();
    }
}