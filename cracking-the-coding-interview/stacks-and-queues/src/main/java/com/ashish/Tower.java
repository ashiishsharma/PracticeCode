package com.ashish;

/**
 * Created by Ashish Sharma on 10/12/2016.
 */
public class Tower {

    private final String towerName;
    private final int towerNumber;

    public Tower(String towerName, int towerNumber) {
        this.towerName = towerName;
        this.towerNumber = towerNumber;
    }

    public String getTowerName() {
        return towerName;
    }

    public int getTowerNumber() {
        return towerNumber;
    }
}
