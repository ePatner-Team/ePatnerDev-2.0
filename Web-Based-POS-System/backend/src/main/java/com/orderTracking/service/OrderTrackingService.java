package com.orderTracking.service;

import com.orderTracking.dto.OrderTrackingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTrackingService {
    public OrderTrackingDTO createOrderTracking(OrderTrackingDTO orderTrackingDTO) {
        // Implementation
    }

    public OrderTrackingDTO getOrderTracking(Long orderId) {
        // Implementation
    }

    public OrderTrackingDTO updateOrderTracking(Long orderId, OrderTrackingDTO orderTrackingDTO) {
        // Implementation
    }

    public List<OrderTrackingDTO> getActiveOrderTrackings() {
        // Implementation
    }

    public OrderTrackingDTO updateDeliveryStatus(Long orderId, String status) {
        // Implementation
    }

    public Long getDeliveryCountdown(Long orderId) {
        // Implementation
    }

    public void cancelOrderTracking(Long orderId) {
        // Implementation
    }
}