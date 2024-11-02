package com.orderTracking.service;

import com.orderTracking.dto.OrderTrackingDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    // Order management functionality
    public OrderDTO createOrder(OrderDTO orderDTO)
    public OrderDTO getOrder(Long orderId)
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO)
    public List<OrderDTO> getAllOrders()
    public void deleteOrder(Long orderId)
}