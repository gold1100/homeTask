package com.hometask.sorter;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class NumbersDTO {

    @NotNull
    private List<Integer> numbers;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private SortOrder order;

    public NumbersDTO() {
    }

    public NumbersDTO(List<Integer> numbers, SortOrder order) {
        this.numbers = numbers;
        this.order = order;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public SortOrder getOrder() {
        return order;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setOrder(SortOrder order) {
        this.order = order;
    }
}
