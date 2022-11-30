package com.hometask.sorter;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/numbers")
@CrossOrigin(origins = "http://localhost:4200/")
public class SorterController {

    private final SorterService sorterService;

    public SorterController(SorterService sorterService) {
        this.sorterService = sorterService;
    }


    @PostMapping(path = "/sort")
    public ResponseEntity<NumbersDTO> sortIntList(@RequestBody @Valid NumbersDTO input){
        if(input.getNumbers().isEmpty()){
            return ResponseEntity.ok().body(input);
        }
        return sorterService.sortIntList(input);
    }
}
