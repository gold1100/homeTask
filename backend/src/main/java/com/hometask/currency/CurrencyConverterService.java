package com.hometask.currency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hometask.exceptions.ApiConnectionStatusException;
import com.hometask.exceptions.CurrencyNotFoundStatusException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CurrencyConverterService {

    private static final String TABLE_A_URI = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";

    public ResponseEntity<CurrencyDTO> getCurrencyValue(@RequestBody @Valid CurrencyDTO dto){
        ResponseEntity<String> response = fetchDataFromNBP();
        if(response.getStatusCode() != HttpStatus.OK){
            throw new ApiConnectionStatusException("Cannot connect to NBP api");
        }
        double value = findCurrencyValue(response.getBody(), dto.getCurrency());
        if(value < 0){
            throw new CurrencyNotFoundStatusException();
        }
        dto.setValue(value);
        return ResponseEntity.ok(dto);
    }

    private ResponseEntity<String> fetchDataFromNBP() {
        RestTemplate client = new RestTemplate();
        return client.getForEntity(TABLE_A_URI, String.class);
    }

    private double findCurrencyValue(String json, String currencyCode){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rates = objectMapper.readTree(json).findPath("rates");
            for (JsonNode currencyData : rates) {
                if (currencyData.get("code").asText().equalsIgnoreCase(currencyCode)) {
                    return currencyData.get("mid").asDouble();
                }
            }
            return -1;
        } catch (JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Json error");
        }
    }
}
