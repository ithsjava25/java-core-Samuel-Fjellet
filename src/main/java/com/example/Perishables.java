package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface Perishables {
    LocalDate expirationDate = null;
    public BigDecimal getPrice();


    UUID uuid();
}
