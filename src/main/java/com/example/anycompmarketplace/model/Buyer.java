package com.example.anycompmarketplace.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Schema(description = "Represents a buyer in the marketplace")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the buyer", example = "1")
    private Long id;

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the buyer", example = "Test User", required = true)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the buyer", example = "testuser@example.com", required = true)
    private String email;

    @OneToMany(mappedBy = "buyer")
    @Schema(description = "List of purchases made by the buyer")
    private List<Purchase> purchasedItems;

    // Constructors
    public Buyer() {
    }

    public Buyer(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<Purchase> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }
}
