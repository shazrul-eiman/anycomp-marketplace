package com.example.anycompmarketplace.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request object for creating a purchase")
public class PurchaseRequest {

    @NotNull(message = "Buyer ID is required")
    @Schema(description = "ID of the buyer making the purchase", example = "1", required = true)
    private Long buyerId;

    @NotNull(message = "Item ID is required")
    @Schema(description = "ID of the item being purchased", example = "1", required = true)
    private Long itemId;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Schema(description = "Quantity of items to purchase", example = "2", required = true, minimum = "1")
    private int quantity;

    // Constructors
    public PurchaseRequest() {
    }

    public PurchaseRequest(Long buyerId, Long itemId, int quantity) {
        this.buyerId = buyerId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
