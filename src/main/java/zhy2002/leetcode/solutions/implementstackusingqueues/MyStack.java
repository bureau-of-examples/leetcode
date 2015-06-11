package zhy2002.leetcode.solutions.implementstackusingqueues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class MyStack {
    private final Queue<Integer> front = new ArrayDeque<>();
    private final Queue<Integer> back = new ArrayDeque<>();
    private Queue<Integer> activeQueue;

    public MyStack(){
        activeQueue = front;
    }

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> inactiveQueue = activeQueue == front ? back : front;
        inactiveQueue.add(x);
        while (!activeQueue.isEmpty())
            inactiveQueue.add(activeQueue.poll());
        activeQueue = inactiveQueue;
    }

    // Removes the element on top of the stack.
    public void pop() {
        activeQueue.poll();
    }

    // Get the top element.
    public int top() {
       return activeQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return activeQueue.isEmpty();
    }
}