package zhy2002.leetcode.solutions.linkedlistrandomnode;

import zhy2002.leetcode.common.ListNode;

import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 */
public class Solution {

    private final ListNode head;
    private final Random random;

    /**
     * @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random(1);
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode current = head;
        ListNode result = current;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
            if (random.nextInt(count) == 0) {
                result = current;
            }
        }
        return result.val;
        //probability of selecting the first:
        // 1/2 * 2/3 * 3/4 * 4/5 * ...
        //select the second:
        // 1/3 * 3/4 * 4/5 * ...
        //select the third:
        //1/4 * 4/5 * ...
        //they are all the same.
        //This algorithm can be used to randomly select k elements from n elements.
    }
}
