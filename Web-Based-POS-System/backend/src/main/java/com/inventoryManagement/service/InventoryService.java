package com.inventoryManagement.service;

import com.inventoryManagement.dto.InventoryDTO;
import com.inventoryManagement.entity.InventoryEntity;
import com.inventoryManagement.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import java.io.ByteArrayOutputStream;
import java.util.Map;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Placeholder method to generate inventory reports in PDF or Excel
    public byte[] generateInventoryReport(Long warehouseId, Long categoryId, String format) {
        // Fetch the data based on warehouseId and categoryId filters
        List<InventoryEntity> inventoryList = inventoryRepository.findAll(); // Simplified query, add warehouse and
                                                                             // category filtering

        // Generate the report based on the format
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if ("pdf".equalsIgnoreCase(format)) {
            // Placeholder for PDF generation logic
            generatePDFReport(outputStream, inventoryList);
        } else if ("excel".equalsIgnoreCase(format)) {
            // Placeholder for Excel generation logic
            generateExcelReport(outputStream, inventoryList);
        }

        // Return the byte array of the generated report
        return outputStream.toByteArray();
    }

    private void generatePDFReport(ByteArrayOutputStream outputStream, List<InventoryEntity> inventoryList) {
        // Mock-up of PDF generation logic. You can use libraries like JasperReports,
        // iText, etc.
        // This is just a placeholder. Replace with actual PDF creation.
        try {
            String pdfContent = "PDF Report for Inventory";
            outputStream.write(pdfContent.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateExcelReport(ByteArrayOutputStream outputStream, List<InventoryEntity> inventoryList) {
        // Mock-up of Excel generation logic. You can use libraries like Apache POI.
        // This is just a placeholder. Replace with actual Excel creation.
        try {
            String excelContent = "Excel Report for Inventory";
            outputStream.write(excelContent.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example logic for inventory turnover calculation
    public Map<String, Double> getInventoryTurnover(String startDate, String endDate) {
        // Fetch product data and sales between the given dates and calculate turnover
        // Turnover = COGS (Cost of Goods Sold) / Average Inventory

        List<InventoryEntity> inventoryList = inventoryRepository.findAll(); // Simplified query to get all products
        Map<String, Double> turnoverRates = new HashMap<>();

        for (InventoryEntity product : inventoryList) {
            double averageInventory = (product.getStockLevel()) / 2.0; // Simplified calculation for example purposes
            double cogs = product.getStockLevel() * 10; // Assuming a cost per product unit for example purposes
            double turnover = cogs / (averageInventory == 0 ? 1 : averageInventory); // Avoid division by zero
            turnoverRates.put(product.getName(), turnover);
        }

        return turnoverRates;
    }

    // Stock update method with validations and stock adjustment logic
    public void updateStock(Long productId, int quantity, Long warehouseId, Long batchId) {
        // Fetch the product entity by productId
        InventoryEntity product = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update the stock level (this is a simple adjustment logic, you can enhance it
        // based on your needs)
        product.setStockLevel(product.getStockLevel() + quantity);

        // Save the updated stock level back to the repository
        inventoryRepository.save(product);

        // Add additional logic if you are dealing with specific warehouse and batch
        // adjustments
        // E.g., if the product stock is tracked across multiple warehouses and batches.
    }

    public List<InventoryDTO> getAllProducts(Long categoryId, Long warehouseId, int page, int size, String[] sort) {
        // Add filtering and sorting logic here
        List<InventoryEntity> products = inventoryRepository.findAll(); // Simplified

        // Convert entities to DTOs
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public InventoryDTO addProduct(InventoryDTO productDTO) {
        InventoryEntity productEntity = convertToEntity(productDTO);
        InventoryEntity savedProduct = inventoryRepository.save(productEntity);
        return convertToDTO(savedProduct);
    }

    public InventoryDTO updateProduct(Long id, InventoryDTO productDTO) {
        // Find existing product, update and save
        InventoryEntity productEntity = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productEntity.setName(productDTO.getName()); // Update other fields as necessary
        InventoryEntity updatedProduct = inventoryRepository.save(productEntity);
        return convertToDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        inventoryRepository.deleteById(id);
    }

    public List<InventoryDTO> getLowStockProducts(int threshold) {
        List<InventoryEntity> products = inventoryRepository.findByStockLevelLessThan(threshold); // Example query
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Conversion methods
    private InventoryDTO convertToDTO(InventoryEntity entity) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSku(entity.getSku());
        dto.setStockLevel(entity.getStockLevel());
        dto.setPrice(entity.getPrice());

        if (entity.getCategory() != null) {
            dto.setCategoryId(entity.getCategory().getId()); // Correct setter for Category ID
        }

        if (entity.getWarehouse() != null) {
            dto.setWarehouseId(entity.getWarehouse().getId()); // Correct setter for Warehouse ID
        }

        return dto;
    }

    private InventoryEntity convertToEntity(InventoryDTO dto) {
        InventoryEntity entity = new InventoryEntity();
        entity.setName(dto.getName());
        entity.setStockLevel(dto.getStockLevel());
        // Convert other fields
        return entity;
    }
}
