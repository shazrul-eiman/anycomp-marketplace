package com.example.anycompmarketplace.controller;

import com.example.anycompmarketplace.model.Buyer;
import com.example.anycompmarketplace.model.Item;
import com.example.anycompmarketplace.model.Purchase;
import com.example.anycompmarketplace.dto.PurchaseRequest;
import com.example.anycompmarketplace.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@Tag(name = "Purchases", description = "Purchase transaction operations")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Create a purchase", description = "Process a purchase transaction where a buyer purchases items from a seller. "
            +
            "This operation will:\n" +
            "- Validate item availability\n" +
            "- Check sufficient quantity\n" +
            "- Deduct quantity from item stock\n" +
            "- Create purchase record\n" +
            "- Link buyer, item, and seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Purchase created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class))),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid input data or insufficient quantity", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"error\": \"Item not available or insufficient quantity.\"}"))),
            @ApiResponse(responseCode = "404", description = "Buyer or Item not found")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Purchase> createPurchase(
            @Parameter(description = "Purchase request containing buyer ID, item ID, and quantity", required = true) @Valid @RequestBody PurchaseRequest purchaseRequest) {

        Purchase purchase = new Purchase();
        purchase.setBuyer(new Buyer());
        purchase.getBuyer().setId(purchaseRequest.getBuyerId());
        purchase.setItem(new Item());
        purchase.getItem().setId(purchaseRequest.getItemId());
        purchase.setQuantity(purchaseRequest.getQuantity());

        try {
            Purchase createdPurchase = purchaseService.createPurchase(purchase);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPurchase);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Get all purchases", description = "Retrieve a list of all purchase transactions in the marketplace")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of purchases", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class)))
    })
    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @Operation(summary = "Get purchase by ID", description = "Retrieve a specific purchase transaction by its unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchase found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class))),
            @ApiResponse(responseCode = "404", description = "Purchase not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(
            @Parameter(description = "ID of the purchase to retrieve", example = "1") @PathVariable Long id) {
        Purchase purchase = purchaseService.getPurchaseById(id);
        return purchase != null ? ResponseEntity.ok(purchase) : ResponseEntity.notFound().build();
    }
}
