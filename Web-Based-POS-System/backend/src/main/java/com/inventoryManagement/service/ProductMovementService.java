package com.inventoryManagement.service;

import com.inventoryManagement.dto.ProductMovementDTO;
import com.inventoryManagement.entity.ProductMovementEntity;
import com.inventoryManagement.repository.ProductMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMovementService {

    @Autowired
    private ProductMovementRepository productMovementRepository;

    public List<ProductMovementDTO> getProductMovements(Long productId, Long warehouseId, String startDate,
            String endDate) {
        // Add filtering by warehouse and date range
        List<ProductMovementEntity> movements = productMovementRepository.findByProductId(productId);
        return movements.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ProductMovementDTO convertToDTO(ProductMovementEntity entity) {
        ProductMovementDTO dto = new ProductMovementDTO();
        dto.setProductId(entity.getProduct().getId());
        dto.setWarehouseId(entity.getWarehouse().getId());
        dto.setMovementDate(entity.getMovementDate());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }
}
