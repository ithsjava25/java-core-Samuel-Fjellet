package com.example;

import java.math.BigDecimal;
import java.util.UUID;



public abstract class Product implements Perishables {
    UUID uuid;
    String name;
    Category category;
    BigDecimal price;


    public BigDecimal price() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }

    public Category category() {
        return category;
    }

    public abstract String productDetails();

}
