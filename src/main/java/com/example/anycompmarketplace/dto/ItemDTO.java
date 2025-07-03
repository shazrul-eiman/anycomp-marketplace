package com.example.anycompmarketplace.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Data Transfer Object for Item information")
public class ItemDTO {

    @Schema(description = "Unique identifier of the item", example = "1")
    private Long id;

    @NotBlank(message = "Item name is required")
    @Schema(description = "Name of the item", example = "Laptop", required = true)
    private String name;

    @Schema(description = "Detailed description of the item", example = "High-performance gaming laptop")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Schema(description = "Price of the item", example = "999.99", required = true)
    private double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    @Schema(description = "Available quantity of the item", example = "10", required = true)
    private int quantity;

    // Constructors
    public ItemDTO() {
    }

    public ItemDTO(Long id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
