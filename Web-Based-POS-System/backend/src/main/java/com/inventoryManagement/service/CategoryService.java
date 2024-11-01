package com.inventoryManagement.service;

import com.inventoryManagement.dto.CategoryDTO;
import com.inventoryManagement.entity.CategoryEntity;
import com.inventoryManagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = convertToEntity(categoryDTO);
        CategoryEntity newCategory = categoryRepository.save(categoryEntity);
        return convertToDTO(newCategory);
    }

    private CategoryDTO convertToDTO(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    private CategoryEntity convertToEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        return entity;
    }
}
