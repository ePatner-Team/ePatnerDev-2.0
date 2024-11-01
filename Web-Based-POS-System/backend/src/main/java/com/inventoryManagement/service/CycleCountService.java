package com.inventoryManagement.service;

import com.inventoryManagement.dto.CycleCountDTO;
import com.inventoryManagement.entity.CycleCountEntity;
import com.inventoryManagement.repository.CycleCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.stream.Collectors;

@Service
public class CycleCountService {

    @Autowired
    private CycleCountRepository cycleCountRepository;

    public CycleCountDTO initiateCycleCount(CycleCountDTO cycleCountDTO) {
        CycleCountEntity cycleCountEntity = convertToEntity(cycleCountDTO);
        CycleCountEntity newCycleCount = cycleCountRepository.save(cycleCountEntity);
        return convertToDTO(newCycleCount);
    }

    public CycleCountDTO updateCycleCount(Long id, CycleCountDTO cycleCountDTO) {
        CycleCountEntity cycleCountEntity = cycleCountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cycle count not found"));
        cycleCountEntity.setCountedQuantity(cycleCountDTO.getCountedQuantity());
        CycleCountEntity updatedCycleCount = cycleCountRepository.save(cycleCountEntity);
        return convertToDTO(updatedCycleCount);
    }

    private CycleCountDTO convertToDTO(CycleCountEntity entity) {
        CycleCountDTO dto = new CycleCountDTO();
        dto.setId(entity.getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setCountedQuantity(entity.getCountedQuantity());
        dto.setWarehouseId(entity.getWarehouse().getId());
        dto.setCycleDate(entity.getCycleDate());
        return dto;
    }

    private CycleCountEntity convertToEntity(CycleCountDTO dto) {
        CycleCountEntity entity = new CycleCountEntity();
        entity.setCountedQuantity(dto.getCountedQuantity());
        // Set other fields and references like product and warehouse
        return entity;
    }
}
