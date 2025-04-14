package ru.tbank.fdsspring.repository;

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
    DELETE FROM currency c WHERE
    c.id = :id
    """, nativeQuery = true)
    boolean deleteCurrencyByID(Long id);

    @Query(value= """
    UPDATE currency
    SET name = :name, basecurrency = :basecurrency, pricechangerate = :pricechangerate, description = :description
    WHERE id = :id
    """, nativeQuery = true)
    void updateCurrencyByID(Long id, String name, String basecurrency, String pricechangerate, String description);
}
