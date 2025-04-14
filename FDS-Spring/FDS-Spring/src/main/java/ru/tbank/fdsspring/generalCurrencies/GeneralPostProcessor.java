package ru.tbank.fdsspring.generalCurrencies;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tbank.fdsspring.specificCurrency.CurrencyRepository;
import ru.tbank.fdsspring.schemas.Currency;
import ru.tbank.fdsspring.schemas.CurrencyRequest;

import java.lang.reflect.Array;
import java.util.AbstractMap;
//import java.util.Pair;



@RestController
public class GeneralPostProcessor {


    public Array currencies;
    public CurrencyRepository repo;

    public void AddCurrency(AbstractMap.SimpleEntry<String, Integer> cur){
        //
    }

    @PostMapping("/currencies")
    public ResponseEntity<Currency> addCurrency(@RequestBody CurrencyRequest req){
        if(1==1) {
            Currency newCurrency = new Currency(req);
            repo.save(newCurrency);
            return ResponseEntity.ok(newCurrency);
        }
        else return (ResponseEntity<Currency>) ResponseEntity.badRequest();
    }
}
