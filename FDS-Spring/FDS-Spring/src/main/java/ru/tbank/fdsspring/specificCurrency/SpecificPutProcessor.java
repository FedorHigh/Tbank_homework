package ru.tbank.fdsspring.specificCurrency;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.AbstractMap;


@RestController
public class SpecificPutProcessor {



    @PostMapping("/currencies/{id}")
    public ResponseEntity<Integer> AddCurrency(@PathVariable String id){
        return ResponseEntity.ok(69);
    }
}
