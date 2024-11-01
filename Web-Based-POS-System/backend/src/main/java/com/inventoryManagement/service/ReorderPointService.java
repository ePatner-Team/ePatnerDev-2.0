package com.inventoryManagement.service;

import com.inventoryManagement.dto.ReorderPointDTO;
import com.inventoryManagement.entity.ReorderPointEntity;
import com.inventoryManagement.repository.ReorderPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReorderPointService {

    @Autowired
    private ReorderPointRepository reorderPointRepository;

    public List<ReorderPointDTO> getReorderPoints() {
        List<ReorderPointEntity> reorderPoints = reorderPointRepository.findAll();
        return reorderPoints.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReorderPointDTO setReorderPoint(ReorderPointDTO reorderPointDTO) {
        ReorderPointEntity reorderPointEntity = convertToEntity(reorderPointDTO);
        ReorderPointEntity newReorderPoint = reorderPointRepository.save(reorderPointEntity);
        return convertToDTO(newReorderPoint);
    }

    private ReorderPointDTO convertToDTO(ReorderPointEntity entity) {
        ReorderPointDTO dto = new ReorderPointDTO();
        dto.setId(entity.getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setReorderLevel(entity.getReorderLevel());
        return dto;
    }

    private ReorderPointEntity convertToEntity(ReorderPointDTO dto) {
        ReorderPointEntity entity = new ReorderPointEntity();
        entity.setReorderLevel(dto.getReorderLevel());
        return entity;
    }
}
