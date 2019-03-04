package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.6
 * <p>
 * <B>Towers of Hanoi:</B>
 * <p>
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which
 * can slide onto any tower.
 * The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (i.e., each disk sits on top of an even larger one).
 * <pre>
 * You have the following constraints:
 * (1) Only one disk can be moved at a time.
 *
 * (2) A disk is slid off the top of one tower onto another tower.
 *
 * (3) A disk cannot be placed on top of a smaller disk.
 *
 * </pre>
 * Write a program to move the disks from the first tower to the last using Stacks.
 * <p>
 *
 * <B>Solution:</B>
 * <pre>
 * <code>
 * moveDisks(int n, Tower origin, Tower destination, Tower buffer) {
 * // Base case
 * if(n<=0)return;
 *
 * //move top n - 1 disks from origin to buffer, using destination as a buffer.
 * moveDisks(n-1,origin,buffer,destination);
 *
 * //move top from origin to destination
 * moveTop(origin, destination);
 *
 * //move top n - 1 disks from buffer to destination, using origin as a buffer.
 * moveDisks(n-1,buffer,destination,origin);
 * }
 * </code>
 * </pre>
 *
 * @author Ashish Sharma on 03/04/2019.
 * @since 03/04/2019.
 */

public class TowersOfHanoiTest {

    @BeforeMethod
    public void init() {
    }

    @Test
    public void testTowersOfHanoi() {
        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
