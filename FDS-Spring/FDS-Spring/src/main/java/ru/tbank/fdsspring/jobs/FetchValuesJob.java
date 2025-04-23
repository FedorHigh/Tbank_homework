package ru.tbank.fdsspring.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tbank.fdsspring.schemas.Currency;
import ru.tbank.fdsspring.service.RestFetcherService;
import ru.tbank.fdsspring.repository.CurrencyRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Component
public class FetchValuesJob {

    @Autowired
    private CurrencyRepository repo;
    @Autowired
    private RestFetcherService fetcher;

    @Scheduled(cron = "0/10 * * * * ?")
    public void fecthAndUpdateCurrencies(){
        //repo = null;
        List<Currency> updates = fetcher.FecthCurrenciesFromCbr();
        for(Currency update : updates){
            try{
                System.out.println(update.basecurrency + " " + update.pricechangerate);
                if(Objects.equals(update.basecurrency, "EUR"))System.out.println("!!!!!!!!");
                repo.updatePriceChangeRateByBaseCurrency(update.basecurrency, update.pricechangerate);
            }catch (Exception ignored){
                System.out.println("!!!???!!!!!" + ignored.toString());
            };
        }
    }
}
