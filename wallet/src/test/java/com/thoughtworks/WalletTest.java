package com.thoughtworks;

import com.thoughtworks.exceptions.NegativeCurrencyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {

    @Test
    public void shouldAddMoneyWhenUserCredits() throws NegativeCurrencyException {
        Rupee rupee = new Rupee(0.0);
        Wallet wallet = new Wallet(rupee);
        Rupee tenRupee = new Rupee(10.0);

        wallet.credit(tenRupee);
        Rupee balance = wallet.balance();

        assertEquals(balance, tenRupee);
    }


}
