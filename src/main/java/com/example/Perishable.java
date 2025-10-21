package com.example;

import java.time.LocalDate;

interface Perishable {
    LocalDate expirationDate();

    default Boolean isExpired(Perishable perishable) {
        return LocalDate.now().isAfter(perishable.expirationDate());
    }

}
