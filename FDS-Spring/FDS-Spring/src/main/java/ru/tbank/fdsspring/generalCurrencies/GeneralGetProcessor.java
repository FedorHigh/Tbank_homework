package ru.tbank.fdsspring.generalCurrencies;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tbank.fdsspring.specificCurrency.CurrencyRepository;
import ru.tbank.fdsspring.schemas.Currency;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.List;
//import java.util.Pair;



@RestController
public class GeneralGetProcessor {


    public Array currencies;
    public CurrencyRepository repo;

    public void AddCurrency(AbstractMap.SimpleEntry<String, Integer> cur){
        //
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getCurrencies(){
        return ResponseEntity.ok(repo.GetAllCurrencies());
    }
}
