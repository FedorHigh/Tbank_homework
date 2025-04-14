package ru.tbank.fdsspring.generalCurrencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tbank.fdsspring.schemas.CurrencyRequest;
import ru.tbank.fdsspring.specificCurrency.CurrencyRepository;
import ru.tbank.fdsspring.schemas.Currency;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.List;
//import java.util.Pair;



@RestController
public class CurrencyController {

    @Autowired
    public CurrencyRepository repo;

    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getCurrencies(){
        return ResponseEntity.ok(repo.GetAllCurrencies());
        //return ResponseEntity.ok(currencies);
    }

    @PostMapping("/currencies")
    public ResponseEntity<Currency> addCurrency(@RequestBody CurrencyRequest req){
        Currency newCurrency = new Currency(req);
        try {
            repo.save(newCurrency);
        }catch (Exception a)
        {
            System.out.println(a.toString());
        }
        return ResponseEntity.ok(newCurrency);
    }
}
