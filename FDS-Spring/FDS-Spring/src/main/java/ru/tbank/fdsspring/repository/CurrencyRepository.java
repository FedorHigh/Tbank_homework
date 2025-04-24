package ru.tbank.fdsspring.repository;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tbank.fdsspring.schemas.Currency;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query(value= """
    SELECT * FROM currency
    """, nativeQuery = true)
    List<Currency> getAllCurrencies();


    @Query(value= """
    SELECT * FROM currency c WHERE
    c.id = :id
    """, nativeQuery = true)
    Currency getCurrencyByID(Long id);

    @Query(value= """
    SELECT * FROM currency c WHERE
    c.base_currency = :b
    """, nativeQuery = true)
    Currency getCurrencyByBaseCurrency(String b);

    @Query(value= """
    DELETE FROM currency c WHERE
    c.id = :id
    """, nativeQuery = true)
    boolean deleteCurrencyByID(Long id);

    @Query(value= """
    UPDATE currency
    SET name = :name, baseCurrency = :baseCurrency, priceChangeRate = :priceChangeRate, description = :description
    WHERE id = :id
    """, nativeQuery = true)
    void updateCurrencyByID(Long id, String name, String baseCurrency, String priceChangeRate, String description);

    @Query(value= """
            UPDATE currency
               SET price_change_rate = :p
             WHERE base_currency = :b
    """, nativeQuery = true)
    void updatepriceChangeRateBybaseCurrency(String b, String p);
}
