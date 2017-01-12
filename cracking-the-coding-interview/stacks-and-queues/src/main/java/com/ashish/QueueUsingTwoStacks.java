package com.ashish;

/**
 * @author Ashish Sharma on 1/5/2017.
 * @since 1/5/2017
 */
public class QueueUsingTwoStacks<T> {

    private Stack<T> enQueueStack;
    private Stack<T> deQueueStack;

    public QueueUsingTwoStacks() {
        enQueueStack = new Stack();
        deQueueStack = new Stack();
    }

    public void enqueue(T element) {
        enQueueStack.push(element);
    }

    public int getQueueCount() {
        return enQueueStack.stackLength() + deQueueStack.stackLength();
    }

    public T deQueue() {
        T element = null;
        if (!deQueueStack.isEmpty()) {
            element = deQueueStack.pop();
        } else if (!enQueueStack.isEmpty()) {
            while (!enQueueStack.isEmpty()) {
                deQueueStack.push(enQueueStack.pop());
            }
            if (!deQueueStack.isEmpty()) {
                element = deQueueStack.pop();
            }
        }
        return element;
    }

    public T peek() {
        T element = null;
        if (!deQueueStack.isEmpty()) {
            element = deQueueStack.peek();
        } else if (!enQueueStack.isEmpty()) {
            while (!enQueueStack.isEmpty()) {
                deQueueStack.push(enQueueStack.pop());
            }
            if (!deQueueStack.isEmpty()) {
                element = deQueueStack.peek();
            }
        }
        return element;
    }
}
