package zhy2002.leetcode.solutions.removeduplicatesfromsortedlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        //remove the next node if it is a duplicate
        ListNode currentNode = head;
        int currentValue = currentNode.val;
        while (currentNode.next != null) {
            if (currentNode.next.val == currentValue) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
                currentValue = currentNode.val;
            }
        }
        return head;
    }

}
