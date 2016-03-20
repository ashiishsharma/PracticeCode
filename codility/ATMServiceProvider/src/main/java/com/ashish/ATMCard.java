package com.ashish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaashis on 11/5/2015.
 */
public class ATMCard {

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    List<BankAccount> bankAccountList;

    public ATMCard() {
        bankAccountList = new ArrayList<BankAccount>();
    }
}
