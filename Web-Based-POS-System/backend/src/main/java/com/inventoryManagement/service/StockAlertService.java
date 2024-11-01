package com.inventoryManagement.service;

import com.inventoryManagement.dto.StockAlertDTO;
import com.inventoryManagement.entity.StockAlertEntity;
import com.inventoryManagement.repository.StockAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockAlertService {

    @Autowired
    private StockAlertRepository stockAlertRepository;

    public List<StockAlertDTO> getStockAlerts() {
        List<StockAlertEntity> stockAlerts = stockAlertRepository.findAll();
        return stockAlerts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public StockAlertDTO createStockAlert(StockAlertDTO stockAlertDTO) {
        StockAlertEntity stockAlertEntity = convertToEntity(stockAlertDTO);
        StockAlertEntity newStockAlert = stockAlertRepository.save(stockAlertEntity);
        return convertToDTO(newStockAlert);
    }

    private StockAlertDTO convertToDTO(StockAlertEntity entity) {
        StockAlertDTO dto = new StockAlertDTO();
        dto.setId(entity.getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setAlertThreshold(entity.getAlertThreshold());
        return dto;
    }

    private StockAlertEntity convertToEntity(StockAlertDTO dto) {
        StockAlertEntity entity = new StockAlertEntity();
        entity.setAlertThreshold(dto.getAlertThreshold());
        // Set other fields
        return entity;
    }
}
