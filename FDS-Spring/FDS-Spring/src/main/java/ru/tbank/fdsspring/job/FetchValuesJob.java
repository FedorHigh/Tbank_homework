package ru.tbank.fdsspring.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tbank.fdsspring.schemas.Currency;
import ru.tbank.fdsspring.service.RestFetcherService;
import ru.tbank.fdsspring.specificCurrency.CurrencyRepository;

import java.util.List;

@Component
public class FetchValuesJob {

    @Autowired
    private CurrencyRepository repo;
    public RestFetcherService fetcher;

    @Scheduled(cron = "0/10 * * * * ?")
    void fecthAndUpdateCurrencies(){
        List<Currency> updates = fetcher.FecthCurrenciesFromCbr();
        for(Currency update : updates){
            try{
                //repo.UpdatePriceChangeRateByBaseCurrency(update.basecurrency);
            }catch (Exception _){};
        }
    }
}
