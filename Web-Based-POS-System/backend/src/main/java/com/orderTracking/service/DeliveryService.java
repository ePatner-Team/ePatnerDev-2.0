package com.orderTracking.service;

import com.orderTracking.dto.DeliveryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class DeliveryService {
    // Delivery management functionality
    public abstract DeliveryDTO assignDelivery(Long orderId, DeliveryDTO deliveryDTO);

    public abstract DeliveryDTO updateDeliveryStatus(Long deliveryId, String status);

    public abstract DeliveryDTO getDeliveryDetails(Long deliveryId);

    public abstract List<DeliveryDTO> getActiveDeliveries();
}
