package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Perishable extends Product{
    public LocalDate expirationDate() {
        return LocalDate.now();
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
