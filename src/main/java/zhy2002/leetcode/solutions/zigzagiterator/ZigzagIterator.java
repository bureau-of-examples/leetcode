package zhy2002.leetcode.solutions.zigzagiterator;

import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-iterator/
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {

    private static class Node {
        public Node next;
        public Node previous;
        public List<Integer> list;

        Node(List<Integer> list) {
            this.list = list;
        }
    }

    private Node headPointer = new Node(null);
    private Node tailPointer = headPointer;
    private Node currentNode;
    private int currentIndex;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        append(new Node(v1));
        append(new Node(v2));
        currentNode = headPointer.next;
        currentIndex = 0;
        skipToNext();
    }

    private void append(Node node) {
        tailPointer.next = node;
        node.previous = tailPointer;
        tailPointer = node;
    }

    private void remove(Node node) {
        if (node == tailPointer) {
            tailPointer = node.previous;
            tailPointer.next = null;
        } else {
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
    }

    public int next() {
        int value = currentNode.list.get(currentIndex);

        //locate to next
        currentNode = currentNode.next;
        skipToNext();
        if(currentNode == null) {
            currentIndex++;
            currentNode = headPointer.next;
            skipToNext();
        }
        return value;
    }

    private void skipToNext() {
        while (currentNode != null && currentIndex >= currentNode.list.size()) {
            Node toRemove = currentNode;
            currentNode = currentNode.next;
            remove(toRemove);
        }
    }

    public boolean hasNext() {
        return currentNode != null;
    }
}
