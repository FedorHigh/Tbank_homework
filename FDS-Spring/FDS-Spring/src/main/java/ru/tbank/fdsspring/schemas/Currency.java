package ru.tbank.fdsspring.schemas;

import jakarta.persistence.Entity;
import lombok.*;
import ru.tbank.fdsspring.CurrencyRepository;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Currency {
    String id;
    String name;
    String baseCurrency = "RUB";
    String priceChangeRate;
    String description;

    public Currency(CurrencyRequest req) {
        name = req.name;
        baseCurrency = req.baseCurrency;
        priceChangeRate = req.priceChangeRate;
        description = req.description;
    }
}
