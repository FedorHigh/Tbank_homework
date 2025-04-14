package ru.tbank.fdsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FdsSpringApplication {

    //public GetProcessor gpr = new GetProcessor();
    //gpr.currencies

    public static void main(String[] args) {
        SpringApplication.run(FdsSpringApplication.class, args);
    }

}
