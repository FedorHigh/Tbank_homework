package ru.tbank.fdsspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.tbank.fdsspring.service.CurrencyService;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
