package com.ashish;

/**
 * <B>10.10</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Rank from Stream:</B>
 * <p>
 * Imagine you are reading in a stream of integers. Periodically, you wish
 * to be able to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated, and the method
 * getRankOfNumber(int x), which returns the number of values less than or equal to x (not
 * including x itself).
 * EXAMPLE
 * Stream(in order of appearance):5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(l) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 *
 * Solution : Insert the stream values in a Binary Search Tree and then do an In Order traversal of the tree till the
 * target element to be found.
 *
 * In order traversal of Binary Search Tree gives a sorted array, so one can easily get the rank from there.
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class RankFromStreamTest {
}
