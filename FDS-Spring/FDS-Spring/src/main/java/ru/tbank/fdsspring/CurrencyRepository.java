package ru.tbank.fdsspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tbank.fdsspring.schemas.Currency;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query(value= """
    SELECT * FROM currency
    """)
    List<Currency> GetAllCurrencies();


    @Query(value= """
    SELECT c FROM currency c WHERE
    c.id == :id
    """)
    Currency GetCurrencyByID(Long id);
}
