package zhy2002.leetcode.solutions.removenthnodefromendoflist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Use two pointers to locate the previous of node to be deleted.
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode first = head;
        ListNode second = head;
        int counter = 0;
        while (first != null) {
            first = first.next;
            if (counter > n)
                second = second.next;
            counter++;

        }
        if (counter < n) {
            return head;
        } else if (counter == n) {
            return second.next;
        } else {
            second.next = second.next.next;
            return head;
        }
    }
}
