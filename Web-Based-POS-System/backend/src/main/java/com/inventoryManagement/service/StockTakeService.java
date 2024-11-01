package com.inventoryManagement.service;

import com.inventoryManagement.dto.StockTakeDTO;
import com.inventoryManagement.entity.StockTakeEntity;
import com.inventoryManagement.repository.StockTakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockTakeService {

    @Autowired
    private StockTakeRepository stockTakeRepository;

    public StockTakeDTO initiateStockTake(StockTakeDTO stockTakeDTO) {
        StockTakeEntity stockTakeEntity = convertToEntity(stockTakeDTO);
        StockTakeEntity newStockTake = stockTakeRepository.save(stockTakeEntity);
        return convertToDTO(newStockTake);
    }

    public StockTakeDTO updateStockTake(Long id, StockTakeDTO stockTakeDTO) {
        StockTakeEntity stockTakeEntity = stockTakeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock take not found"));
        // Update the stock take details
        StockTakeEntity updatedStockTake = stockTakeRepository.save(stockTakeEntity);
        return convertToDTO(updatedStockTake);
    }

    private StockTakeDTO convertToDTO(StockTakeEntity entity) {
        StockTakeDTO dto = new StockTakeDTO();
        dto.setId(entity.getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setStockLevel(entity.getStockLevel());
        return dto;
    }

    private StockTakeEntity convertToEntity(StockTakeDTO dto) {
        StockTakeEntity entity = new StockTakeEntity();
        entity.setStockLevel(dto.getStockLevel());
        // Set other fields and references
        return entity;
    }
}
