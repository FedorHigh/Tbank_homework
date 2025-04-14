package ru.tbank.fdsspring.schemas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Currency {
    @Id
    private String id;
    private String name;
    private String baseCurrency = "RUB";
    private String priceChangeRate;
    private String description;

    public Currency(CurrencyRequest req) {
        name = req.name;
        baseCurrency = req.baseCurrency;
        priceChangeRate = req.priceChangeRate;
        description = req.description;
    }
}
