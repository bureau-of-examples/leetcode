package zhy2002.leetcode.solutions.implementqueueusingstacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * Implement the following operations of a queue using stacks:
 * push, pop, peek, empty
 */
public class MyQueue {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!outStack.isEmpty()){
            outStack.pop();
            return;
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}
