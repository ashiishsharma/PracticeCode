package com.ashish;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by shaashis on 11/5/2015.
 */
public class ATMTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testATMFunctionality() {
        ATMCard atmCard = new ATMCard();
        ATM atm = new ATM(atmCard);
    }

    @Test
    public void testMoneyWithdrawal() {
        ATMCard atmCard = new ATMCard();
        ATM atm = new ATM(atmCard);
        atm.setCardAuthorized(atm.authorize(atmCard, "123456"));
        int requestedAmount = 40;
        int cashAmount = atm.dispenseCash(requestedAmount);
        Assert.assertEquals(cashAmount, 40);
    }

    @Test
    public void testMoneyDeposit(){
        ATMCard atmCard = new ATMCard();
        ATM atm = new ATM(atmCard);
        atm.setCardAuthorized(atm.authorize(atmCard, "123456"));


    }
}
