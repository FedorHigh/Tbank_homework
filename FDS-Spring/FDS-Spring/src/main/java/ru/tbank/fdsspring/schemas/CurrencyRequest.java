package ru.tbank.fdsspring.schemas;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class CurrencyRequest {
    String name;
    String baseCurrency = "RUB";
    String priceChangeRate;
    String description;
}
