package ru.tbank.fdsspring.generalCurrencies;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.AbstractMap;
//import java.util.Pair;



@RestController
public class GeneralGetProcessor {


    public Array currencies;

    public void AddCurrency(AbstractMap.SimpleEntry<String, Integer> cur){
        //
    }

    @GetMapping("/currencies")
    public ResponseEntity<Array> GetCurrencies(){
        return ResponseEntity.ok(currencies);
    }
}
