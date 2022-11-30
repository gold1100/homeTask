package com.hometask.sorter;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterServiceTest {


    SorterService underTest = new SorterService();

    @Test
    void itShouldSortAsc() {
        //given
        NumbersDTO data = new NumbersDTO();
        data.setNumbers(new ArrayList<>(List.of(2,1,7,5)));
        data.setOrder(SortOrder.ASC);

        //when
        ResponseEntity<NumbersDTO> result = underTest.sortIntList(data);

        // then
        assertNotNull(result.getBody());
        assertEquals(List.of(1,2,5,7), result.getBody().getNumbers());
        assertNotEquals(List.of(2,1,7,5), result.getBody().getNumbers());
    }

    @Test
    void itShouldSortAscWhenSortOrderIsNull() {
        //given
        NumbersDTO data = new NumbersDTO();
        data.setNumbers(new ArrayList<>(List.of(2,1,7,5)));
        data.setOrder(null);

        //when
        ResponseEntity<NumbersDTO> result = underTest.sortIntList(data);

        // then
        assertNotNull(result.getBody());
        assertEquals(List.of(1,2,5,7), result.getBody().getNumbers());
        assertNotEquals(List.of(2,1,7,5), result.getBody().getNumbers());
    }

    @Test
    void itShouldSortDesc() {
        //given
        NumbersDTO data = new NumbersDTO();
        data.setNumbers(new ArrayList<>(List.of(2,1,7,5)));
        data.setOrder(SortOrder.DESC);

        //when
        ResponseEntity<NumbersDTO> result = underTest.sortIntList(data);

        // then
        assertNotNull(result.getBody());
        assertEquals(List.of(7,5,2,1), result.getBody().getNumbers());
        assertNotEquals(List.of(2,1,7,5), result.getBody().getNumbers());
    }
}