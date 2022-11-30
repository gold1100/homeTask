package com.hometask.sorter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SorterService {
    public ResponseEntity<NumbersDTO> sortIntList(NumbersDTO input) {
        SortOrder order = input.getOrder() == null ? SortOrder.ASC : input.getOrder();
        switch (order) {
            case ASC -> {
                Collections.sort(input.getNumbers());
                return ResponseEntity.ok(input);
            }
            case DESC -> {
                input.getNumbers().sort(Collections.reverseOrder());
                return ResponseEntity.ok(input);
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
