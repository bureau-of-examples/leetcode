package zhy2002.leetcode.solutions.copylistwithrandompointer;

import zhy2002.leetcode.common.RandomListNode;

/**
 * 1) Duplicate each node; e.g. 1 -> 2 -> 3 => 1 -> 1 -> 2 -> 2 -> 3 -> 3
 * 2) Adjust next and random pointer to point to the next (the duplicate)
 * 3) Split the list in 2
 */
public class InPlaceSolution implements Solution {

    @Override
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        RandomListNode current = head;

        //duplicate
        while (current != null) {
            RandomListNode next = current.next;
            current.next = new RandomListNode(current.label);
            current.next.random = current.random;
            current.next.next = next;
            current = next;
        }

        //adjust
        current = head;
        int count = 0;
        while (current != null) {
            if (count % 2 == 1 && current.random != null) {
                current.random = current.random.next; //the next one is the duplicate
            }
            current = current.next;
            count++;
        }

        //split
        current = head;
        RandomListNode duplicateHead = null, duplicateTail = null;
        while (current != null) {
            if (duplicateHead == null) {
                duplicateHead = duplicateTail = current.next;
            } else {
                duplicateTail.next = current.next;
                duplicateTail = duplicateTail.next;
            }
            current.next = current.next.next;
            current = current.next;
        }

        return duplicateHead;
    }
}
