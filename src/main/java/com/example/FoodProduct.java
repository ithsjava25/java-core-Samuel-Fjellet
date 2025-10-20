package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FoodProduct extends Product implements Perishables, Shippable {
    public LocalDate expirationDate;
    public BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight) {
        super(id, name, category, price);

    }


    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public UUID uuid() {
        return null;
    }

    @Override
    public String productDetails() {
        return "";
    }

    @Override
    public double weight() {
        return 0;
    }

    @Override
    public BigDecimal calculateShippingCost() {
        return null;
    }
}

/*
Implements Perishable and Shippable.
Fields: LocalDate expirationDate, BigDecimal weight (kg).
Validations: negative price -> IllegalArgumentException("Price cannot be negative."); negative weight -> IllegalArgumentException("Weight cannot be negative.").
productDetails() should look like: "Food: Milk, Expires: 2025-12-24".
Shipping rule: cost = weight * 50.
 */