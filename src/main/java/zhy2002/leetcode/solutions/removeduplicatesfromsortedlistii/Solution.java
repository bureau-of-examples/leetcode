package zhy2002.leetcode.solutions.removeduplicatesfromsortedlistii;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class Solution {

    /**
     * Use two pointers, the first points to the first distinct node.
     * The second pointer is used to count number of same nodes after the distinct node.
     * When the second pointer meets a different node:
     * If count > 1 then the duplicate nodes are deleted
     * else the first pointer can progress by one
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode current = head;
        int sameCount = 1;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                current = current.next;
                sameCount++;
            } else {
                if (sameCount > 1) {
                    prev.next = current.next;
                    current = current.next;
                } else {
                    prev = current;
                    current = current.next;
                }
                sameCount = 1;
            }
        }
        return sentinel.next;
    }
}
