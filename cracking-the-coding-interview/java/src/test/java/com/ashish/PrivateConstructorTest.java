package com.ashish;

/**
 * <B>13.1</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Private Constructor:</B>
 * <p>
 * In terms of inheritance, what is the effect of keeping a constructor private?
 * <p>
 * Solution : Declaring a constructor private on class A means that you can only access the (private) constructor if you
 * could also access A's private methods. Who, other than A, can access A's private methods and constructor?
 * A's inner classes can. Additionally, if A is an inner class of Q, then Q's other inner classes can.
 * This has direct implications for inheritance, since a subclass calls its parent's constructor. The class A can be
 * inherited, but only by its own or its parent's inner classes.
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class PrivateConstructorTest {
}
