package ru.tbank.fdsspring.generalCurrencies;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.AbstractMap;




@RestController
public class GeneralPostProcessor {
    @PostMapping("/currencies")
    public ResponseEntity<String> AddCurrency(@RequestBody String reqName){
        if(!reqName.isEmpty() && reqName != null) return ResponseEntity.ok(reqName);
        else return (ResponseEntity<String>) ResponseEntity.badRequest();
    }
}
