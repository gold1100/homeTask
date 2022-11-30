package com.hometask.currency;

import com.hometask.exceptions.CurrencyNotFoundStatusException;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


class CurrencyConverterServiceTest {
    CurrencyConverterService underTest = new CurrencyConverterService();

    @Test
    void itShouldReturnValidResponse() {
        // given
        CurrencyDTO input = new CurrencyDTO();
        input.setCurrency("THB");

        // when
        ResponseEntity<CurrencyDTO> response = underTest.getCurrencyValue(input);

        // then
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getCurrency(), "THB");
        assertTrue(response.getBody().getValue() > 0 );
    }

    @Test
    void itShouldThrowCurrencyNotFoundExceptionWhenInputCurrencyDontExist(){
        // given
        CurrencyDTO input = new CurrencyDTO();
        input.setCurrency("LLL");

        // then
        assertThrows(CurrencyNotFoundStatusException.class, () -> underTest.getCurrencyValue(input));
    }

}