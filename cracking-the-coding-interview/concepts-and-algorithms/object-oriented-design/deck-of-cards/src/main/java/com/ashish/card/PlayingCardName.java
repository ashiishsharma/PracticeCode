package com.ashish.card;

/**
 * Created by shshaash on 4/5/2017.
 */
public enum PlayingCardName{
    Ace("ACE", 1),
    Two("Two", 2),
    Three("Three", 3),
    Four("Four", 4),
    Five("Five", 5),
    Six("Six", 6),
    Seven("Seven", 7),
    Eight("Eight", 8),
    Nine("Nine", 9),
    Ten("Ten", 10),
    Jack("Jack", 11),
    Queen("Queen", 12),
    King("King", 13);

    private String cardName;
    private int cardValue;

    PlayingCardName(String cardName, int cardValue) {
        this.cardName = cardName;
        this.cardValue = cardValue;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }
}
