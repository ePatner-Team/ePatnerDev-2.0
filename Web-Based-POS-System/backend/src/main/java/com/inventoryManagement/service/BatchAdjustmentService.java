package com.inventoryManagement.service;

import com.inventoryManagement.dto.BatchAdjustmentDTO;
import com.inventoryManagement.entity.BatchAdjustmentEntity;
import com.inventoryManagement.repository.BatchAdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchAdjustmentService {

    @Autowired
    private BatchAdjustmentRepository batchAdjustmentRepository;

    public BatchAdjustmentDTO recordBatchAdjustment(BatchAdjustmentDTO adjustmentDTO) {
        BatchAdjustmentEntity adjustmentEntity = convertToEntity(adjustmentDTO);
        BatchAdjustmentEntity recordedAdjustment = batchAdjustmentRepository.save(adjustmentEntity);
        return convertToDTO(recordedAdjustment);
    }

    public List<BatchAdjustmentDTO> getBatchAdjustments(Long batchId, String startDate, String endDate) {
        List<BatchAdjustmentEntity> adjustments = batchAdjustmentRepository.findByBatchIdAndDateRange(batchId,
                startDate, endDate);
        return adjustments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BatchAdjustmentDTO convertToDTO(BatchAdjustmentEntity entity) {
        BatchAdjustmentDTO dto = new BatchAdjustmentDTO();
        dto.setId(entity.getId());
        dto.setBatchId(entity.getBatch().getId());
        dto.setAdjustmentReason(entity.getAdjustmentReason());
        dto.setAdjustmentQuantity(entity.getAdjustmentQuantity());
        dto.setAdjustmentDate(entity.getAdjustmentDate());
        return dto;
    }

    private BatchAdjustmentEntity convertToEntity(BatchAdjustmentDTO dto) {
        BatchAdjustmentEntity entity = new BatchAdjustmentEntity();
        entity.setAdjustmentReason(dto.getAdjustmentReason());
        entity.setAdjustmentQuantity(dto.getAdjustmentQuantity());
        // Set other fields and references like batch
        return entity;
    }
}
