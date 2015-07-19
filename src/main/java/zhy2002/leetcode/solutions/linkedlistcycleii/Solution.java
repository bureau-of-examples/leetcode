package zhy2002.leetcode.solutions.linkedlistcycleii;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {

    /**
     * Set a fast pointer and a slow pointer both start from the head.
     * At each step the fast pointer advance two nodes and the slow pointer advance one node.
     * If there is a cycle the two nodes will meet (pointing to the same node) after some steps.
     * When this happens move the fast pointer back to head, and now let both pointers advance one node per step.
     * After some steps they will meet at the beginning of the cycle.
     *
     * @param head head of a linked list which might contain a cycle.
     * @return begin node of the cycle, or null if there is no cycle.
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {//detect if there is loop
            if (fast == null)
                return null;
            fast = fast.next;

            if (fast == null)
                return null;
            fast = fast.next;

            slow = slow.next;

        } while (fast != slow);

        //reset fast pointer to head and both move one node at each step.
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
