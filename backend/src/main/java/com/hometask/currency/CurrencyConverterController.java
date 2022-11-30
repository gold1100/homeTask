package com.hometask.currency;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/currencies")
public class CurrencyConverterController {

    private final CurrencyConverterService service;

    public CurrencyConverterController(CurrencyConverterService service) {
        this.service = service;
    }

    @PostMapping(path = "/get-current-currency-value")
    public ResponseEntity<CurrencyDTO> getCurrencyValue(@RequestBody @Valid CurrencyDTO dto){
        return service.getCurrencyValue(dto);
    }
}
