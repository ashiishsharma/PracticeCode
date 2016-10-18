package com.ashish;

/**
 * Created by Ashish Sharma on 10/12/2016.
 */
public class Tower {

    private final String towerName;
    private final int towerNumber;
    private final Stack<Disk> towerStack;

    public Tower(String towerName, int towerNumber) {
        this.towerName = towerName;
        this.towerNumber = towerNumber;
        this.towerStack = new Stack<Disk>();
    }

    public String getTowerName() {
        return towerName;
    }

    public int getTowerNumber() {
        return towerNumber;
    }

    public Stack<Disk> getTowerStack() {
        return towerStack;
    }

    /**
     * Publish Tower disk from top to bottom
     */
    public void publishTowerDisks() {
        System.out.println("***** Disk Status *****");
        do {
            System.out.println(towerStack.pop().getDiskNumber());
        } while (towerStack.stackLength() > 0);
    }
}
