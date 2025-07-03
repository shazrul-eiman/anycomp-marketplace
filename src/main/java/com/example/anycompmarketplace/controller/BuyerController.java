package com.example.anycompmarketplace.controller;

import com.example.anycompmarketplace.model.Buyer;
import com.example.anycompmarketplace.service.BuyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
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
@RequestMapping("/buyers")
@Tag(name = "Buyers", description = "Buyer management operations")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @Operation(summary = "Get all buyers", description = "Retrieve a list of all registered buyers in the marketplace")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of buyers", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @Operation(summary = "Get buyer by ID", description = "Retrieve a specific buyer by their unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buyer found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Buyer.class))),
            @ApiResponse(responseCode = "404", description = "Buyer not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(
            @Parameter(description = "ID of the buyer to retrieve", example = "1") @PathVariable Long id) {
        Buyer buyer = buyerService.getBuyerById(id);
        return buyer != null ? ResponseEntity.ok(buyer) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new buyer", description = "Register a new buyer in the marketplace")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Buyer created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Buyer.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer createBuyer(
            @Parameter(description = "Buyer information to create") @Valid @RequestBody Buyer buyer) {
        return buyerService.createBuyer(buyer);
    }

    @Operation(summary = "Update buyer", description = "Update an existing buyer's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buyer updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Buyer.class))),
            @ApiResponse(responseCode = "404", description = "Buyer not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PutMapping("/{id}")
    public Buyer updateBuyer(
            @Parameter(description = "ID of the buyer to update", example = "1") @PathVariable Long id,
            @Parameter(description = "Updated buyer information") @Valid @RequestBody Buyer buyer) {
        return buyerService.updateBuyer(id, buyer);
    }

    @Operation(summary = "Delete buyer", description = "Remove a buyer from the marketplace")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Buyer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Buyer not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(
            @Parameter(description = "ID of the buyer to delete", example = "1") @PathVariable Long id) {
        buyerService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }
}
