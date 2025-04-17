package ru.tbank.fdsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.tbank.fdsspring.service.RestFetcherService;

@SpringBootApplication
public class FdsSpringApplication {

    //public GetProcessor gpr = new GetProcessor();
    //gpr.currencies

    public static void main(String[] args) {
        RestFetcherService tmp = new RestFetcherService();
        tmp.FecthCurrenciesFromCbr();
        SpringApplication.run(FdsSpringApplication.class, args);
    }

}
