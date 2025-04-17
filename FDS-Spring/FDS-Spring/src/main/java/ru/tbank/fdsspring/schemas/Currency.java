package ru.tbank.fdsspring.schemas;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String name;
    public String basecurrency = "RUB";
    public String pricechangerate;
    public String description;

    public Currency(){};
    public Currency(CurrencyRequest req) {
        name = req.name;
        basecurrency = req.baseCurrency;
        pricechangerate = req.priceChangeRate;
        description = req.description;
    }
}
