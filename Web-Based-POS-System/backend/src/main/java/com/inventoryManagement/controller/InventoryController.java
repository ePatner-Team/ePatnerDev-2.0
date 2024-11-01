package com.inventoryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.inventoryManagement.dto.*;
import com.inventoryManagement.service.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@Validated
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductMovementService productMovementService;

    @Autowired
    private StockTakeService stockTakeService;

    @Autowired
    private StockAlertService stockAlertService;

    @Autowired
    private ReorderPointService reorderPointService;

    @Autowired
    private CycleCountService cycleCountService;

    @Autowired
    private InventoryValuationService inventoryValuationService;

    @Autowired
    private BatchAdjustmentService batchAdjustmentService;

    // Get all products with optional category and warehouse filtering, pagination
    // and sorting
    @GetMapping("/products")
    public ResponseEntity<List<InventoryDTO>> getAllProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long warehouseId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        List<InventoryDTO> products = inventoryService.getAllProducts(categoryId, warehouseId, page, size, sort);
        return ResponseEntity.ok(products);
    }

    // Add a new product with validation
    @PostMapping("/products")
    public ResponseEntity<InventoryDTO> addProduct(@Valid @RequestBody InventoryDTO productDTO) {
        InventoryDTO newProduct = inventoryService.addProduct(productDTO);
        return ResponseEntity.ok(newProduct);
    }

    // Update an existing product
    @PutMapping("/products/{id}")
    public ResponseEntity<InventoryDTO> updateProduct(@PathVariable Long id,
            @Valid @RequestBody InventoryDTO productDTO) {
        InventoryDTO updatedProduct = inventoryService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a product by ID
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        inventoryService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Get all categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    // Add a new category
    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO newCategory = categoryService.addCategory(categoryDTO);
        return ResponseEntity.ok(newCategory);
    }

    // Update stock information
    // Stock update method with unpacked parameters from StockUpdateRequest
    @PostMapping("/stock/update")
    public ResponseEntity<Void> updateStock(@RequestBody @Valid StockUpdateRequest updateInfo) {
        inventoryService.updateStock(updateInfo.getProductId(), updateInfo.getQuantity(), updateInfo.getWarehouseId(),
                updateInfo.getBatchId());
        return ResponseEntity.ok().build();
    }

    // Get products with low stock based on threshold
    @GetMapping("/low-stock")
    public ResponseEntity<List<InventoryDTO>> getLowStockProducts(@RequestParam int threshold) {
        List<InventoryDTO> lowStockProducts = inventoryService.getLowStockProducts(threshold);
        return ResponseEntity.ok(lowStockProducts);
    }

    // Create a new batch
    @PostMapping("/batches")
    public ResponseEntity<BatchDTO> createBatch(@Valid @RequestBody BatchDTO batchDTO) {
        BatchDTO newBatch = batchService.createBatch(batchDTO);
        return ResponseEntity.ok(newBatch);
    }

    // Get batches for a specific product
    @GetMapping("/batches")
    public ResponseEntity<List<BatchDTO>> getBatches(@RequestParam Long productId) {
        List<BatchDTO> batches = batchService.getBatches(productId);
        return ResponseEntity.ok(batches);
    }

    // Update the expiry date for a batch
    @PatchMapping("/batches/{batchId}/expiry")
    public ResponseEntity<Void> updateExpiry(@PathVariable Long batchId,
            @RequestBody @Valid Map<String, String> expiryInfo) {
        String expiryDate = expiryInfo.get("expiryDate");
        batchService.updateExpiry(batchId, expiryDate);
        return ResponseEntity.ok().build();
    }

    // Get all warehouses
    @GetMapping("/warehouses")
    public ResponseEntity<List<WarehouseDTO>> getWarehouses() {
        List<WarehouseDTO> warehouses = warehouseService.getWarehouses();
        return ResponseEntity.ok(warehouses);
    }

    // Add a new warehouse
    @PostMapping("/warehouses")
    public ResponseEntity<WarehouseDTO> addWarehouse(@Valid @RequestBody WarehouseDTO warehouseDTO) {
        WarehouseDTO newWarehouse = warehouseService.addWarehouse(warehouseDTO);
        return ResponseEntity.ok(newWarehouse);
    }

    // Get product movements
    @GetMapping("/product-movements")
    public ResponseEntity<List<ProductMovementDTO>> getProductMovements(
            @RequestParam Long productId,
            @RequestParam(required = false) Long warehouseId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        List<ProductMovementDTO> movements = productMovementService.getProductMovements(productId, warehouseId,
                startDate, endDate);
        return ResponseEntity.ok(movements);
    }

    // Initiate stock take
    @PostMapping("/stock-take")
    public ResponseEntity<StockTakeDTO> initiateStockTake(@RequestBody StockTakeDTO stockTakeDTO) {
        StockTakeDTO newStockTake = stockTakeService.initiateStockTake(stockTakeDTO);
        return ResponseEntity.ok(newStockTake);
    }

    // Update stock take
    @PutMapping("/stock-take/{id}")
    public ResponseEntity<StockTakeDTO> updateStockTake(@PathVariable Long id,
            @RequestBody StockTakeDTO stockTakeDTO) {
        StockTakeDTO updatedStockTake = stockTakeService.updateStockTake(id, stockTakeDTO);
        return ResponseEntity.ok(updatedStockTake);
    }

    // Get stock alerts
    @GetMapping("/stock-alerts")
    public ResponseEntity<List<StockAlertDTO>> getStockAlerts() {
        List<StockAlertDTO> stockAlerts = stockAlertService.getStockAlerts();
        return ResponseEntity.ok(stockAlerts);
    }

    // Create stock alert
    @PostMapping("/stock-alerts")
    public ResponseEntity<StockAlertDTO> createStockAlert(@RequestBody StockAlertDTO stockAlertDTO) {
        StockAlertDTO newStockAlert = stockAlertService.createStockAlert(stockAlertDTO);
        return ResponseEntity.ok(newStockAlert);
    }

    // Set reorder point
    @PostMapping("/reorder-points")
    public ResponseEntity<ReorderPointDTO> setReorderPoint(@RequestBody ReorderPointDTO reorderPointDTO) {
        ReorderPointDTO newReorderPoint = reorderPointService.setReorderPoint(reorderPointDTO);
        return ResponseEntity.ok(newReorderPoint);
    }

    // Get all reorder points
    @GetMapping("/reorder-points")
    public ResponseEntity<List<ReorderPointDTO>> getReorderPoints() {
        List<ReorderPointDTO> reorderPoints = reorderPointService.getReorderPoints();
        return ResponseEntity.ok(reorderPoints);
    }

    // Perform inventory valuation
    @PostMapping("/inventory-valuation")
    public ResponseEntity<InventoryValuationDTO> performInventoryValuation(
            @RequestBody InventoryValuationDTO valuationDTO) {
        InventoryValuationDTO performedValuation = inventoryValuationService.performInventoryValuation(valuationDTO);
        return ResponseEntity.ok(performedValuation);
    }

    // Get inventory turnover
    @GetMapping("/inventory-turnover")
    public ResponseEntity<Map<String, Double>> getInventoryTurnover(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        Map<String, Double> turnoverRates = inventoryService.getInventoryTurnover(startDate, endDate);
        return ResponseEntity.ok(turnoverRates);
    }

    // Record batch adjustment
    @PostMapping("/batch-adjustments")
    public ResponseEntity<BatchAdjustmentDTO> recordBatchAdjustment(@RequestBody BatchAdjustmentDTO adjustmentDTO) {
        BatchAdjustmentDTO recordedAdjustment = batchAdjustmentService.recordBatchAdjustment(adjustmentDTO);
        return ResponseEntity.ok(recordedAdjustment);
    }

    // Get batch adjustments
    @GetMapping("/batch-adjustments")
    public ResponseEntity<List<BatchAdjustmentDTO>> getBatchAdjustments(
            @RequestParam(required = false) Long batchId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        List<BatchAdjustmentDTO> adjustments = batchAdjustmentService.getBatchAdjustments(batchId, startDate,
                endDate);
        return ResponseEntity.ok(adjustments);
    }

    // Initiate cycle count
    @PostMapping("/cycle-count")
    public ResponseEntity<CycleCountDTO> initiateCycleCount(@RequestBody CycleCountDTO cycleCountDTO) {
        CycleCountDTO initiatedCycleCount = cycleCountService.initiateCycleCount(cycleCountDTO);
        return ResponseEntity.ok(initiatedCycleCount);
    }

    // Update cycle count
    @PutMapping("/cycle-count/{id}")
    public ResponseEntity<CycleCountDTO> updateCycleCount(@PathVariable Long id,
            @RequestBody CycleCountDTO cycleCountDTO) {
        CycleCountDTO updatedCycleCount = cycleCountService.updateCycleCount(id, cycleCountDTO);
        return ResponseEntity.ok(updatedCycleCount);
    }

    // Generate inventory report
    @GetMapping("/inventory-report")
    public ResponseEntity<byte[]> generateInventoryReport(
            @RequestParam(required = false) Long warehouseId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String format) {
        byte[] report = inventoryService.generateInventoryReport(warehouseId, categoryId, format);
        return ResponseEntity.ok()
                .header("Content-Type", format.equals("pdf") ? "application/pdf" : "application/vnd.ms-excel")
                .header("Content-Disposition", "attachment; filename=inventory_report." + format)
                .body(report);
    }

}
