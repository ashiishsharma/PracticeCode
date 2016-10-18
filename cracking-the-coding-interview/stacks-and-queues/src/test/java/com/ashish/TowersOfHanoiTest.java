package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 3.4
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
 * different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * in ascending order of size from top to bottom (i.e., each disk sits on top of an even
 * larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next rod.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using Stacks.
 * <p>
 * Created by Ashish Sharma on 12-10-2016.
 */
public class TowersOfHanoiTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void towerOfHanoiTest() {
        Tower towerOne = new Tower("Tower-One", 1);
        Disk disk = new Disk("1", 1);
    }

    /**
     * For case of one disk only
     */
    @Test
    public void arrangeTowerDiskTest1() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        Disk diskOne = new Disk("Disk-One", 1);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskOne);

        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree());

        towersOfHanoi.getTowerThree().publishTowerDisks();
    }

    /**
     * For case of two disk
     */
    @Test
    public void arrangeTowerDiskTest2() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        Disk diskOne = new Disk("Disk-One", 1);
        Disk diskTwo = new Disk("Disk-Two", 2);

        towersOfHanoi.getTowerOne().getTowerStack().push(diskTwo);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskOne);

        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerTwo());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerTwo(), towersOfHanoi.getTowerThree());

        towersOfHanoi.getTowerThree().publishTowerDisks();
    }

    /**
     * For case of three disk
     */
    @Test
    public void arrangeTowerDiskTest3() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        Disk diskOne = new Disk("Disk-One", 1);
        Disk diskTwo = new Disk("Disk-Two", 2);
        Disk diskThree = new Disk("Disk-Three", 3);

        towersOfHanoi.getTowerOne().getTowerStack().push(diskThree);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskTwo);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskOne);

        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerTwo());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerThree(), towersOfHanoi.getTowerTwo());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerTwo(), towersOfHanoi.getTowerOne());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerTwo(), towersOfHanoi.getTowerThree());
        towersOfHanoi.moveDisk(towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree());


        towersOfHanoi.getTowerThree().publishTowerDisks();
    }

    /**
     * For case of 4 disk
     */
    @Test
    public void arrangeTowerDiskTest4() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        Disk diskOne = new Disk("Disk-One", 1);
        Disk diskTwo = new Disk("Disk-Two", 2);
        Disk diskThree = new Disk("Disk-Three", 3);
        Disk diskFour = new Disk("Disk-Four", 4);

        towersOfHanoi.getTowerOne().getTowerStack().push(diskFour);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskThree);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskTwo);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskOne);

     /* The recursion of the method involves moving the buffer and destination towers
        as mentioned in the code*/
        towersOfHanoi.moveDisksSolution(4, towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree(), towersOfHanoi.getTowerTwo());

        towersOfHanoi.getTowerThree().publishTowerDisks();
    }

    /**
     * For case of any number of disk
     */
    @Test
    public void arrangeTowerDiskTest() {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        Disk diskOne = new Disk("Disk-One", 1);
        Disk diskTwo = new Disk("Disk-Two", 2);
        Disk diskThree = new Disk("Disk-Three", 3);
        Disk diskFour = new Disk("Disk-Four", 4);
        Disk diskFive = new Disk("Disk-Five", 5);
        Disk diskSix = new Disk("Disk-Six", 6);
        Disk diskSeven = new Disk("Disk-Seven", 7);
        Disk diskEight = new Disk("Disk-Eight", 8);
        Disk diskNine = new Disk("Disk-Nine", 9);
        Disk diskTen = new Disk("Disk-Ten", 10);

        towersOfHanoi.getTowerOne().getTowerStack().push(diskTen);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskNine);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskEight);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskSeven);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskSix);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskFive);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskFour);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskThree);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskTwo);
        towersOfHanoi.getTowerOne().getTowerStack().push(diskOne);

     /* The recursion of the method involves moving the buffer and destination towers
        as mentioned in the code*/
        towersOfHanoi.moveDisksSolution(10, towersOfHanoi.getTowerOne(), towersOfHanoi.getTowerThree(), towersOfHanoi.getTowerTwo());

        towersOfHanoi.getTowerThree().publishTowerDisks();
    }
}
