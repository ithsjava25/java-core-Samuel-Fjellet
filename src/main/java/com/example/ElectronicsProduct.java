package com.example;

import java.math.BigDecimal;
import java.util.UUID;

public class ElectronicsProduct extends Product {
    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warranty, BigDecimal weight) {
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
