package ru.tbank.fdsspring.specificCurrency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tbank.fdsspring.schemas.Currency;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query(value= """
    SELECT * FROM currency
    """, nativeQuery = true)
    List<Currency> GetAllCurrencies();


    @Query(value= """
    SELECT * FROM currency c WHERE
    c.id = :id
    """, nativeQuery = true)
    Currency GetCurrencyByID(Long id);
}
