package com.thoughtworks;

import com.thoughtworks.exceptions.NegativeCurrencyException;

import java.util.Objects;

public class Rupee {

    private final double value;

    public Rupee(double value) throws NegativeCurrencyException {
        validate(value);

        this.value = value;
    }

    public void validate(double value) throws NegativeCurrencyException {
        if (value < 0) {
            throw new NegativeCurrencyException();
        }
    }


    public double value() {
        return this.value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rupee rupee = (Rupee) o;
        return Double.compare(rupee.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
