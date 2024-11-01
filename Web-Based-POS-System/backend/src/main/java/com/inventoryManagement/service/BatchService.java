package com.inventoryManagement.service;

import com.inventoryManagement.dto.BatchDTO;
import com.inventoryManagement.entity.BatchEntity;
import com.inventoryManagement.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define the date format

    public BatchDTO createBatch(BatchDTO batchDTO) {
        BatchEntity batchEntity = convertToEntity(batchDTO);
        BatchEntity newBatch = batchRepository.save(batchEntity);
        return convertToDTO(newBatch);
    }

    public List<BatchDTO> getBatches(Long productId) {
        List<BatchEntity> batches = batchRepository.findByProductId(productId);
        return batches.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Method to update the expiry date
    public void updateExpiry(Long batchId, String expiryDate) {
        BatchEntity batchEntity = batchRepository.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        try {
            Date date = dateFormat.parse(expiryDate); // Convert String to Date
            batchEntity.setExpiryDate(date); // Set the Date object
            batchRepository.save(batchEntity);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    private BatchDTO convertToDTO(BatchEntity entity) {
        BatchDTO dto = new BatchDTO();
        dto.setId(entity.getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setExpiryDate(entity.getExpiryDate());
        return dto;
    }

    private BatchEntity convertToEntity(BatchDTO dto) {
        BatchEntity entity = new BatchEntity();
        entity.setExpiryDate(dto.getExpiryDate());
        // Set other fields and references
        return entity;
    }
}
