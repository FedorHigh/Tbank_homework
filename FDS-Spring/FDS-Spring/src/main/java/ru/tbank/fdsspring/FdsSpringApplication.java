package ru.tbank.fdsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import ru.tbank.fdsspring.service.RestFetcherService;
=======
=======
>>>>>>> Stashed changes
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.tbank.fdsspring.jobs.FetchValuesJob;
>>>>>>> Stashed changes

@SpringBootApplication
@EnableScheduling
public class FdsSpringApplication {

    //public GetProcessor gpr = new GetProcessor();
    //gpr.currencies
<<<<<<< Updated upstream
=======
    //@Autowired
    //public static FetchValuesJob test = new FetchValuesJob();
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

    public static void main(String[] args) {
        RestFetcherService tmp = new RestFetcherService();
        tmp.FecthCurrenciesFromCbr();
        SpringApplication.run(FdsSpringApplication.class, args);
<<<<<<< Updated upstream
=======


       // test.fecthAndUpdateCurrencies();
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }

}
