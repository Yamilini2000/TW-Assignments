package com.thoughtworks;

import com.thoughtworks.exceptions.NegativeCurrencyException;

public class Wallet {
    private Rupee amount;

    public Wallet(Rupee rupee) {
        amount = rupee;
    }

    public void credit(Rupee rupee) throws NegativeCurrencyException {
        this.amount = new Rupee(this.amount.value() + rupee.value());

    }

    public Rupee balance() {
        return amount;
    }
}
