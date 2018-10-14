package zhy2002.leetcode.solutions.maxstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaxStack {

    private static class ListNode {
        ListNode previous, next;
        int val;

        public ListNode(int x) {
            val = x;
        }
    }

    private final ListNode sentinel = new ListNode(-1);
    private final Stack<ListNode> max = new Stack<>();
    private ListNode tail = sentinel;

    /** initialize your data structure here. */
    public MaxStack() {
    }

    private void add(int x) {
        ListNode node = new ListNode(x);
        node.previous = tail;
        tail.next = node;
        tail = node;
    }

    public void push(int x) {
        add(x);
        if (max.isEmpty() || max.peek().val <= x) {
            max.push(tail);
        }
    }

    private int remove() {
        int val = tail.val;
        tail.previous.next = null;
        tail = tail.previous;
        return val;
    }

    public int pop() {
        int val = remove();
        if (max.peek().val == val) {
            max.pop();
        }
        return val;
    }

    public int top() {
        return tail.val;
    }

    public int peekMax() {
        return max.peek().val;
    }

    public int popMax() {
        ListNode node = max.pop();
        int val = node.val;
        node.previous.next = node.next;
        if (node.next != null) {
            node.next.previous = node.previous;
            //rebuild max stack until the end
            node = node.next;
            while (node != null) {
                if (max.isEmpty() || max.peek().val <= node.val) {
                    max.push(node);
                }
                node = node.next;
            }
        } else {
            tail = node.previous;
        }
        return val;
    }
}