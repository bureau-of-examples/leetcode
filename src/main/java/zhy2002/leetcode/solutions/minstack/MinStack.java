package zhy2002.leetcode.solutions.minstack;

import java.util.ArrayList;

/**
 * https://oj.leetcode.com/problems/min-stack/
 * Decide min element when the stack is changed.
 */
public class MinStack {

    private static class Node {

        public Node(int value, Node next){
            this.setValue(value);
            this.setNext(next);
        }

        private Node next;
        private int value;

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private int getValue() {
            return value;
        }

        private void setValue(int value) {
            this.value = value;
        }
    }

    private Node head;//the stack is implemented as a linked list, the stack top element being the first element in the linked list.
    private ArrayList<Node> minValues = new ArrayList<>();//a stack of the minimum elements see so far as the stack grows.

    public void push(int x) {
        this.head = new Node(x, head);
        if(minValues.size() == 0 || x < getMin())
            minValues.add(this.head);
    }

    public void pop() {
        if(this.head == minValues.get(minValues.size() - 1))
            minValues.remove(minValues.size() - 1);
        this.head = this.head.getNext();
    }

    public int top() {
        return this.head.getValue();
    }

    public int getMin() {
        return minValues.get(minValues.size() - 1).getValue();
    }
}
