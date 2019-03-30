package com.ashish;

/**
 * <B>13.2</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Return from Finally:</B>
 * <p>
 * In Java, does the finally block get executed if we insert a return statement
 * inside the try block of a try-catch-finally?
 * <p>
 * Solution : Yes, it will get executed. The finally block gets executed when the try block exits. Even when we
 * attempt to exit within the try block (via a return statement, a continue statement, a break statement
 * or any exception), the finally block will still be executed.
 *
 * Note that there are some cases in which the finally block will not get executed, such as the following:
 * If the java virtual machine exits during try/ catch block execution.
 * If the thread which is executing during the try/ catch block gets killed.
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class ReturnFromFinallyTest {
}
