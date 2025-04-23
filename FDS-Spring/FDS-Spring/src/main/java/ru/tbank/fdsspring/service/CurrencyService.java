package ru.tbank.fdsspring.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tbank.fdsspring.repository.CurrencyRepository;
import ru.tbank.fdsspring.schemas.Currency;

@Service
@NoArgsConstructor
public class CurrencyService {
    @Autowired
    public CurrencyRepository repo;

    public void updateCurrencyByID(Long id, Currency c){
        repo.updateCurrencyByID(id, c.name, c.basecurrency, c.pricechangerate, c.description);
    }
    public void updatePriceChangeRateByBaseCurrency(String b, String p){
        repo.updatePriceChangeRateByBaseCurrency(b, p);
    }
}
