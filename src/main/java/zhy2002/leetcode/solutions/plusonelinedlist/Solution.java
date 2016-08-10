package zhy2002.leetcode.solutions.plusonelinedlist;

import zhy2002.leetcode.common.ListNode;


/**
 * https://leetcode.com/problems/plus-one-linked-list/
 * <p>
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1->2->3
 * <p>
 * Output:
 * 1->2->4
 */
public class Solution {
    public ListNode plusOne(ListNode head) {

        ListNode lastLessThan9 = null;
        ListNode current = head;
        while (current != null) {
            if (current.val < 9) {
                lastLessThan9 = current;
            }
            current = current.next;
        }

        if (lastLessThan9 == null) {
            lastLessThan9 = new ListNode(1);
            lastLessThan9.next = head;
            head = lastLessThan9;
        } else {
            lastLessThan9.val++;
        }

        current = lastLessThan9.next;
        while (current != null) {
            current.val = 0;
            current = current.next;
        }
        return head;
    }
}
