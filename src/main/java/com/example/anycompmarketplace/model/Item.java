package com.example.anycompmarketplace.model;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
// This class represents an item in the marketplace.
// It includes fields for the item's ID, name, description, price, quantity, and
// a reference to the seller.
// The @Entity annotation indicates that this class is a JPA entity.
// The @Id and @GeneratedValue annotations specify that the id field is the
// primary key and its value will be generated automatically.
// The @ManyToOne annotation indicates a many-to-one relationship with the
// Seller entity, where each item is associated with a single seller.
// The @JoinColumn annotation specifies the foreign key column in the database
// that links to the Seller entity.
// This class is used to manage item data in the marketplace, allowing for
// operations such as creating, updating, and retrieving items.
// The getters and setters allow for easy access and modification of these
// fields.
// This is particularly useful in scenarios where you want to return a subset of
// the entity's data to the client.
// This DTO is typically used in service methods to encapsulate item data
// without exposing the entire entity model.
// It helps in maintaining a clean separation between the data layer and the
// service layer.
