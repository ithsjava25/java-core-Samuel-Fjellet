package com.example;

import java.time.LocalDate;
import java.util.UUID;

interface Perishable {
    UUID uuid();
    LocalDate expirationDate();

    default Boolean isExpired(Perishable perishable) {
        return LocalDate.now().isAfter(perishable.expirationDate());
    }

}
