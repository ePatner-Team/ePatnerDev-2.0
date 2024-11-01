package com.inventoryManagement.service;

import com.inventoryManagement.dto.InventoryValuationDTO;
import com.inventoryManagement.entity.InventoryValuationEntity;
import com.inventoryManagement.repository.InventoryValuationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryValuationService {

    @Autowired
    private InventoryValuationRepository inventoryValuationRepository;

    public InventoryValuationDTO performInventoryValuation(InventoryValuationDTO valuationDTO) {
        InventoryValuationEntity valuationEntity = convertToEntity(valuationDTO);
        InventoryValuationEntity performedValuation = inventoryValuationRepository.save(valuationEntity);
        return convertToDTO(performedValuation);
    }

    private InventoryValuationDTO convertToDTO(InventoryValuationEntity entity) {
        InventoryValuationDTO dto = new InventoryValuationDTO();
        dto.setId(entity.getId());
        dto.setTotalValue(entity.getTotalValue());
        dto.setValuationDate(entity.getValuationDate());
        dto.setProductId(entity.getProduct().getId());
        dto.setWarehouseId(entity.getWarehouse().getId());
        return dto;
    }

    private InventoryValuationEntity convertToEntity(InventoryValuationDTO dto) {
        InventoryValuationEntity entity = new InventoryValuationEntity();
        entity.setTotalValue(dto.getTotalValue());
        // Set other fields and references like product and warehouse
        return entity;
    }
}
