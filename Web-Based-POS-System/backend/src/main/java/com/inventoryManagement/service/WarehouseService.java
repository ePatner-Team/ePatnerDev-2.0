package com.inventoryManagement.service;

import com.inventoryManagement.dto.WarehouseDTO;
import com.inventoryManagement.entity.WarehouseEntity;
import com.inventoryManagement.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<WarehouseDTO> getWarehouses() {
        List<WarehouseEntity> warehouses = warehouseRepository.findAll();
        return warehouses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public WarehouseDTO addWarehouse(WarehouseDTO warehouseDTO) {
        WarehouseEntity warehouseEntity = convertToEntity(warehouseDTO);
        WarehouseEntity newWarehouse = warehouseRepository.save(warehouseEntity);
        return convertToDTO(newWarehouse);
    }

    private WarehouseDTO convertToDTO(WarehouseEntity entity) {
        WarehouseDTO dto = new WarehouseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        return dto;
    }

    private WarehouseEntity convertToEntity(WarehouseDTO dto) {
        WarehouseEntity entity = new WarehouseEntity();
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        return entity;
    }
}
