package com.example;

import java.time.LocalDate;

interface Perishable {
    LocalDate expirationDate();
    default boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate());
    }
}
