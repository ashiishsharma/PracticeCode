package com.ashish;

/**
 * Created by Ashish Sharma on 10/18/2016.
 */
public class TowersOfHanoi {

    private final Tower towerOne;
    private final Tower towerTwo;
    private final Tower towerThree;

    public TowersOfHanoi() {
        towerOne = new Tower("Tower-One", 1);
        towerTwo = new Tower("Tower-Two", 2);
        towerThree = new Tower("Tower-Three", 3);
    }

    public Tower getTowerOne() {
        return towerOne;
    }

    public Tower getTowerTwo() {
        return towerTwo;
    }

    public Tower getTowerThree() {
        return towerThree;
    }

    public void moveDisk(Tower towerFrom, Tower towerTo) {
        Disk diskToMove;
        if (towerFrom.getTowerStack().peek() != null) {
            diskToMove = towerFrom.getTowerStack().pop();
            towerTo.getTowerStack().push(diskToMove);
            System.out.println("Disk " + diskToMove.getDiskName() + " moved from "
                    + towerFrom.getTowerName() + " to " + towerTo.getTowerName());
        }
    }

    /**
     * The recursion of the method involves moving the buffer and destination towers
     * as mentioned in the code
     * @param numberOfTopDisksToMove
     * @param towerOne {Source}
     * @param towerThree {Destination}
     * @param towerTwo {Buffer}
     */
    public void moveDisksSolution(int numberOfTopDisksToMove,
                                  Tower towerOne /*Source*/,
                                  Tower towerThree /*Destination*/,
                                  Tower towerTwo /*Buffer*/) {
        if (numberOfTopDisksToMove <= 0) {
            return;
        } else {
            moveDisksSolution(numberOfTopDisksToMove - 1,
                    towerOne /*Source*/,
                    towerTwo /*Destination*/,
                    towerThree /*Buffer*/);

            moveDisk(towerOne/*Source*/, towerThree/*Destination*/);

            moveDisksSolution(numberOfTopDisksToMove - 1,
                    towerTwo /*Source*/,
                    towerThree /*Destination*/,
                    towerOne /*Buffer*/);
        }
    }
}
