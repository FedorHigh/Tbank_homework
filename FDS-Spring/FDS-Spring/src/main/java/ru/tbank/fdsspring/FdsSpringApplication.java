package ru.tbank.fdsspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.tbank.fdsspring.jobs.FetchValuesJob;

@SpringBootApplication
public class FdsSpringApplication {

    //public GetProcessor gpr = new GetProcessor();
    //gpr.currencies
    //@Autowired
    public static FetchValuesJob test = new FetchValuesJob();

    public static void main(String[] args) {
        SpringApplication.run(FdsSpringApplication.class, args);


        test.fecthAndUpdateCurrencies();
    }

}
