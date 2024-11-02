package com.posManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posManagement.dto.BarcodeRequest;
import com.posManagement.dto.InvoiceRequest;
import com.posManagement.dto.ReceiptPrintRequest;
import com.posManagement.entity.Invoice;
import com.posManagement.entity.Product;
import com.posManagement.repository.InvoiceRepository;
import com.posManagement.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PosService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Method to scan barcode and retrieve product information
    public Product scanBarcode(BarcodeRequest barcodeRequest) {
        // Assuming barcodeRequest contains a barcode that matches a product's ID (as a
        // string)
        Long productId = Long.parseLong(barcodeRequest.getBarcode()); // Convert String to Long to match the Product ID
                                                                      // type
        Optional<Product> productOptional = productRepository.findById(productId); // Retrieve product from the
                                                                                   // repository using the ID
        // If the product is not found, throw a runtime exception with a meaningful
        // message
        return productOptional.orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Method to retrieve offline data (handled on frontend)
    public String getOfflineData() {
        // Placeholder logic for offline data retrieval, actual implementation may vary
        // based on frontend caching and IndexedDB usage
        return "Offline data retrieved";
    }

    // Method to generate an invoice based on product IDs and customer details
    public Invoice generateInvoice(InvoiceRequest invoiceRequest) {
        List<Product> productList = new ArrayList<>();
        // Loop through each product ID provided in the request
        for (String productIdString : invoiceRequest.getProductIds()) {
            Long productId = Long.parseLong(productIdString); // Convert String to Long to match the Product ID type
            Optional<Product> productOptional = productRepository.findById(productId); // Retrieve product from the
                                                                                       // repository using the ID
            // If the product is not found, throw a runtime exception with a detailed
            // message
            productList.add(
                    productOptional.orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId)));
        }

        // Create and save the invoice
        Invoice invoice = new Invoice();
        invoice.setProducts(productList); // Set the list of products in the invoice
        invoice.setTotalAmount(productList.stream().mapToDouble(Product::getPrice).sum()); // Calculate the total amount
                                                                                           // by summing the prices of
                                                                                           // all products
        invoice.setCustomerId(invoiceRequest.getCustomerId()); // Set the customer ID from the request
        invoice.setDate(java.time.LocalDate.now().toString()); // Set the current date for the invoice
        return invoiceRepository.save(invoice); // Save the invoice to the repository and return it
    }

    // Method to print a receipt using a connected hardware printer
    public void printReceipt(ReceiptPrintRequest receiptRequest) {
        Long invoiceId = Long.parseLong(receiptRequest.getInvoiceId()); // Convert String to Long to match the Invoice
                                                                        // ID type
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId); // Retrieve invoice from the
                                                                                   // repository using the ID
        Invoice invoice = invoiceOptional.orElseThrow(() -> new RuntimeException("Invoice not found")); // If the
                                                                                                        // invoice is
                                                                                                        // not found,
                                                                                                        // throw a
                                                                                                        // runtime
                                                                                                        // exception

        // Placeholder logic for printing the receipt (e.g., using a hardware printer
        // API)
        // Actual implementation would involve interacting with a printer API or library
        System.out.println("Receipt printed for invoice ID: " + invoice.getId());
    }
}
