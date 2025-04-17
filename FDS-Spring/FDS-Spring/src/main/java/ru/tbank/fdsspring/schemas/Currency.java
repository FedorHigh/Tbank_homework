package ru.tbank.fdsspring.schemas;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String basecurrency = "RUB";
    private String pricechangerate;
    private String description;

    public Currency(CurrencyRequest req) {
        name = req.name;
        basecurrency = req.baseCurrency;
        pricechangerate = req.priceChangeRate;
        description = req.description;
    }
}
