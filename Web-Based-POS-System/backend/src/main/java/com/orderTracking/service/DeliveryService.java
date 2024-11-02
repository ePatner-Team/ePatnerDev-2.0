package com.orderTracking.service;

import com.orderTracking.dto.OrderTrackingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    // Delivery management functionality
    public DeliveryDTO assignDelivery(Long orderId, DeliveryDTO deliveryDTO)
    public DeliveryDTO updateDeliveryStatus(Long deliveryId, String status)
    public DeliveryDTO getDeliveryDetails(Long deliveryId)
    public List<DeliveryDTO> getActiveDeliveries()
}
