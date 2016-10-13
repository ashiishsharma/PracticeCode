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
 *
 * Created by Ashish Sharma on 12-10-2016.
 */
public class TowersOfHanoiTest {

    @BeforeMethod
    public void init(){

    }

    @Test
    public void towerOfHanoiTest(){
        Tower towerOne = new Tower("Tower-One",1);
        Disk disk = new Disk("1",1);

    }
}
