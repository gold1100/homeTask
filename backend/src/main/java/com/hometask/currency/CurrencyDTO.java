package com.hometask.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;

public class CurrencyDTO {

    @Size(min = 3, max = 3, message = "Currency code should be a 3 letter string!")
    private String currency;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double value;

    public CurrencyDTO() {
    }

    public CurrencyDTO(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
