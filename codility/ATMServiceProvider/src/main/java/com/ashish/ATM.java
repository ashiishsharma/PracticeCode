package com.ashish;

/**
 * Created by shaashis on 11/5/2015.
 */
public class ATM {

    private ATMCard atmCard;
    private boolean isCardAuthorized;
    private boolean isTransactionAuthorized;
    private Bank bank;

    public boolean isCardAuthorized() {
        return isCardAuthorized;
    }

    public void setCardAuthorized(boolean cardAuthorized) {
        isCardAuthorized = cardAuthorized;
    }

    public ATM(ATMCard atmCard) {
        this.atmCard = atmCard;
        isCardAuthorized = false;
        isTransactionAuthorized = false;
        bank = new Bank();
    }


    public boolean authorize(ATMCard atmCard, String atmPIN) {
        return true;
    }

    public boolean returnCard() {
        return true;
    }

    public int dispenseCash(int requestedAmount) {
        int cashToDispense = 0;

        BankAccount bankAccount = getBankAccount();
        setBankAccount(bankAccount);

        isTransactionAuthorized = bank.isTransactionApproved(atmCard.getBankAccountList().get(0), atmCard);

        if (isCardAuthorized && isTransactionAuthorized) {
            bankAccount.debitAccountBalance(requestedAmount);
            cashToDispense = requestedAmount;
        }
        return cashToDispense;
    }

    public BankAccount getBankAccount() {
        return new BankAccount(123456, "AshishSharma");
    }

    public void setBankAccount(BankAccount bankAccount) {
        atmCard.getBankAccountList().add(bankAccount);
    }
}
