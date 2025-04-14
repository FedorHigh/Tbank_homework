package ru.tbank.fdsspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.fdsspring.schemas.CurrencyRequest;
import ru.tbank.fdsspring.repository.CurrencyRepository;
import ru.tbank.fdsspring.schemas.Currency;
import ru.tbank.fdsspring.service.CurrencyService;

import java.util.List;
//import java.util.Pair;



@RestController
public class CurrencyController {

    @Autowired
    public CurrencyRepository repo;
    @Autowired
    public CurrencyService service;

    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getCurrencies(){
        return ResponseEntity.ok(repo.getAllCurrencies());
        //return ResponseEntity.ok(currencies);
    }

    @PostMapping("/currencies")
    public ResponseEntity addCurrency(@RequestBody CurrencyRequest req){
        Currency newCurrency = new Currency(req);
        try {
            repo.save(newCurrency);
            return ResponseEntity.ok(newCurrency);
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return (ResponseEntity) ResponseEntity.internalServerError();
        }

    }

    @GetMapping("/currencies/{id}")
    public ResponseEntity getCurrency(@PathVariable Long id){
        try{
            return ResponseEntity.ok(repo.getCurrencyByID(id));
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return (ResponseEntity) ResponseEntity.internalServerError();
        }
    }

    @DeleteMapping("/currencies/{id}")
    public ResponseEntity<Integer> deleteCurrency(@PathVariable Long id){
        boolean ok = false;
        try{
            ok = repo.deleteCurrencyByID(id);
            return ResponseEntity.ok(200);
        }catch (Exception e)
        {
            System.out.println(e.toString());
            if(ok) return ResponseEntity.ok(200);
            return ResponseEntity.ok(500);
        }
    }

    @PutMapping("/currencies/{id}")
    public ResponseEntity updateCurrency(@RequestBody CurrencyRequest req, @PathVariable Long id){
        Currency newCurrency = new Currency(req);
        boolean ok = false;
        try {
            service.updateCurrencyByID(id, newCurrency);
            return ResponseEntity.ok(newCurrency);
        }catch (Exception e)
        {
            System.out.println("!!!!!!!!!!!!!" + e.toString());
            if(ok) return ResponseEntity.ok(newCurrency);
            return ResponseEntity.ok(500);
        }

    }
}
