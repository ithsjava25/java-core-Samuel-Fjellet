package com.example;

import java.math.BigDecimal;
import java.util.UUID;

/*
Implements Shippable.
productDetails() should look like: "Electronics: Laptop, Warranty: 24 months".
Shipping rule: base 79, add 49 if weight > 5.0 kg.
 */

public class ElectronicsProduct extends Product {
    int warrantyMonths;
    BigDecimal weight;


    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warranty, BigDecimal weight) {
        super(id, name, category, price);
        this.warrantyMonths = warranty;
        if (warrantyMonths < 0)
            throw new IllegalArgumentException("Warranty months cannot be negative.");
        this.weight = weight;

    }

    @Override
    public String productDetails() {
        return "";
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public UUID uuid() {
        return null;
    }
}
