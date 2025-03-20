package ru.tbank.fdsspring.specificCurrency;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.AbstractMap;




@RestController
public class SpecificGetProcessor {



    @GetMapping("/currencies/{id}")
    public ResponseEntity<Integer> GetCurrencies(@PathVariable Integer id){
        return ResponseEntity.ok(id);
    }
}
