package com.thoughtworks;

import com.thoughtworks.exceptions.NegativeCurrencyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RupeeTest {
    @Test

    public void shouldNotCreateRupeeWhenItsValueIsNegative() throws NegativeCurrencyException {
        double value = -1;
        assertThrows(NegativeCurrencyException.class, () -> new Rupee(value));
    }
}
