package com.ashish;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 3.5
 * <p>
 * Implement a MyQueue class which implements a queue using two stacks.
 * <p>
 *
 * @author Ashish Sharma on 10/18/2016.
 * @see <a href="http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks">http://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks</a>
 * <p>
 */
public class QueueUsingTwoStacksTest {

    private QueueUsingTwoStacks queueUsingTwoStacks;

    @BeforeMethod
    public void init() {
        queueUsingTwoStacks = new QueueUsingTwoStacks();
    }

    @Test
    public void testEnQueue() {
        queueUsingTwoStacks.enqueue(1);
        queueUsingTwoStacks.enqueue(2);
        queueUsingTwoStacks.enqueue(3);
    }

    @Test
    public void testDeQueue() {
        queueUsingTwoStacks.enqueue(1);
        queueUsingTwoStacks.enqueue(2);
        queueUsingTwoStacks.enqueue(3);

        Assert.assertEquals(queueUsingTwoStacks.deQueue(), 1);
        Assert.assertEquals(queueUsingTwoStacks.deQueue(), 2);
        Assert.assertEquals(queueUsingTwoStacks.deQueue(), 3);
        Assert.assertEquals(queueUsingTwoStacks.deQueue(), null);
        queueUsingTwoStacks.enqueue(4);
        Assert.assertEquals(queueUsingTwoStacks.deQueue(), 4);

    }

}
