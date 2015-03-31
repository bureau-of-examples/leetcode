package zhy2002.leetcode.solutions.swapnodesinpairs;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = head.next;
        ListNode previous = null;//the last of the previous pair
        ListNode first = head;
        ListNode second = head.next;

        do {
            if (previous != null)
                previous.next = second;
            first.next = second.next;
            second.next = first;

            previous = first;
            first = first.next;

        } while (first != null && (second = first.next) != null);

        return newHead;
    }
}
