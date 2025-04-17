package ru.tbank.fdsspring.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.tbank.fdsspring.schemas.Currency;
import ru.tbank.fdsspring.specificCurrency.CurrencyRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RestFetcherService {


    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    public String cbrUrl = "https://www.cbr-xml-daily.ru/daily_json.js";

    public RestFetcherService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public List<Currency> FecthCurrenciesFromCbr(){
        String response = restTemplate.getForObject(cbrUrl, String.class);
        //System.out.println("!!!!!!!!!!!!!!"+response);
        List<Currency> result = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode valuteNode = root.get("Valute");

            if (valuteNode != null) {
                Iterator<Map.Entry<String, JsonNode>> fields = valuteNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    JsonNode node = entry.getValue();

                    Currency cur = new Currency();
                    cur.name = "temporary currency";
                    cur.basecurrency = (node.get("CharCode").asText());
                    Double pricechangerate = 1 - (((node.get("Value").asDouble())/(node.get("Previous").asDouble())));
                    pricechangerate = Math.round(pricechangerate * 100.0)/100.0;

                    if (pricechangerate > 0) cur.pricechangerate = "+" + pricechangerate.toString();
                    else cur.pricechangerate = pricechangerate.toString();

                    //System.out.println(cur.pricechangerate);
                    result.add(cur);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CBR response", e);
        }
        //for(Currency cur : result) System.out.println(cur.toString());
        return result;
    }
}
