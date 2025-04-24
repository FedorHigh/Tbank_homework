package ru.tbank.fdsspring.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tbank.fdsspring.repository.CurrencyRepository;
import ru.tbank.fdsspring.schemas.Currency;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository repo;
    public Currency getCurrencyByID(Long id){
        return repo.getCurrencyByID(id);
    }
    public boolean deleteCurrencyByID(Long id){
        return repo.deleteCurrencyByID(id);
    }
    public Currency getCurrencyByBaseCurrency(String b){
        return repo.getCurrencyByBaseCurrency(b);
    }
    public List<Currency>getAllCurrencies(){
        return repo.getAllCurrencies();
    }
    public void save(Currency c){
        repo.save(c);
    }
    public void updateCurrencyByID(Long id, Currency c){
        repo.updateCurrencyByID(id, c.name, c.baseCurrency, c.priceChangeRate, c.description);
    }
    public void updatepriceChangeRateBybaseCurrency(String b, String p){
        repo.updatepriceChangeRateBybaseCurrency(b, p);
    }
}
