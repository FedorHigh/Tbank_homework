package ru.tbank.fdsspring.jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.tbank.fdsspring.schemas.Currency;
import ru.tbank.fdsspring.service.CurrencyService;
import ru.tbank.fdsspring.service.RestFetcherService;
import ru.tbank.fdsspring.repository.CurrencyRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class FetchValuesJob {
    private final CurrencyService service;
    private final RestFetcherService fetcher;

    @Scheduled(cron = "0/10 * * * * ?")
    @PostConstruct
    public void fecthAndUpdateCurrencies(){
        List<Currency> updates = fetcher.FecthCurrenciesFromCbr();
        for(Currency update : updates){
            try{
                if(service.getCurrencyByBaseCurrency(update.baseCurrency) != null){
                    System.out.println(update.baseCurrency + " has changed by " + update.priceChangeRate + "%");
                    service.updatepriceChangeRateBybaseCurrency(update.baseCurrency, update.priceChangeRate);
                }
                //System.out.println(update.baseCurrency + " " + update.priceChangeRate);
                //if(Objects.equals(update.baseCurrency, "EUR"))System.out.println("!!!!!!!!");

            }catch (Exception ignored){
                //System.out.println("!!!???!!!!!" + ignored.toString());
            };
        }
    }
}
