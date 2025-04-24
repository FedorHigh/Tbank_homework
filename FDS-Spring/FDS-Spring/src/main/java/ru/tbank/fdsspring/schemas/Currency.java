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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public String basecurrency = "RUB";
    public String pricechangerate;
=======
    public String baseCurrency = "RUB";
    public String priceChangeRate;
>>>>>>> Stashed changes
=======
    public String baseCurrency = "RUB";
    public String priceChangeRate;
>>>>>>> Stashed changes
=======
    public String baseCurrency = "RUB";
    public String priceChangeRate;
>>>>>>> Stashed changes
    public String description;

    public Currency(){};
    public Currency(CurrencyRequest req) {
        name = req.name;
        baseCurrency = req.baseCurrency;
        priceChangeRate = req.priceChangeRate;
        description = req.description;
    }
}
