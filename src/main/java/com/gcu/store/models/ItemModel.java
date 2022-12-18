package com.gcu.store.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class ItemModel {

    @Id
    private long id;
    @Size(min = 1, max = 30, message = "name must be between 1 and 30 characters")
    private String name;
    @Size(min = 1, max = 200, message = "name must be between 1 and 200 characters")
    private String description;
    private int sku;
    private int quantity;
    private double price;

    public ItemModel () {}

    public ItemModel(long id, String name, String description, int sku, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
