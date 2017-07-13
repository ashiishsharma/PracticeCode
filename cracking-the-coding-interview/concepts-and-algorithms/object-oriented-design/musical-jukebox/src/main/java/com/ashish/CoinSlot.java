package com.ashish;

/**
 * Created by shshaash on 7/13/2017.
 */
public class CoinSlot {

    public boolean insertCoin(int i) {
        boolean rightCoinInserted = false;
        if (i == 1) {
            System.out.println("Coin of denomination: " + i + " inserted");
            rightCoinInserted = true;
        } else {
            System.out.println("Coin of invalid denomination: " + i + " inserted, returned ...");
            rightCoinInserted = false;
        }
        return rightCoinInserted;
    }
}
