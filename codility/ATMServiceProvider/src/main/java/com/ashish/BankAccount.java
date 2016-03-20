package com.ashish;

/**
 * Created by shaashis on 11/5/2015.
 */
public class BankAccount {

    private int bankAccountNumber;
    private String holderName;

    public void creditAccountBalance(int creditAmount) {
        accountBalance = accountBalance + creditAmount;
    }

    public void debitAccountBalance(int debitAmount) {
        accountBalance = accountBalance - debitAmount;
    }

    private int accountBalance;

    public BankAccount(int bankAccountNumber, String holderName) {
        this.bankAccountNumber = bankAccountNumber;
        this.holderName = holderName;
        accountBalance = 0;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
