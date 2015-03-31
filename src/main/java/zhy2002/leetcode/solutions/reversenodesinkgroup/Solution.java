package zhy2002.leetcode.solutions.reversenodesinkgroup;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Point to the first and the last in k-group, and then reverse.
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;

        ListNode first, last, result;
        first = last = head;
        result = null;
        ListNode lastLast = null;

        int count = 0;
        while (last != null) {
            count++;
            if (count < k) {
                last = last.next;
            } else {
                if (result == null) {
                    result = last;
                    lastLast = first;
                } else {
                    lastLast.next = last; //last node of previous segment.
                    lastLast = first;
                }

                ListNode next = last.next;
                ListNode current = first;
                ListNode nextFirst = last.next;
                while (next != last) {
                    ListNode temp = current.next;
                    current.next = next;
                    next = current;
                    current = temp;
                }
                first = last = nextFirst;
                count = 0;
            }
        }

        return result == null ? head : result;

    }


}
