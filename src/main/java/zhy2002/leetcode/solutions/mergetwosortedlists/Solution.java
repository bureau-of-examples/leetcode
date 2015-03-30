package zhy2002.leetcode.solutions.mergetwosortedlists;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        while (true) {
            if (l1 != null) {
                if (l2 != null) {
                    if (l1.val <= l2.val) {
                        result.next = l1;
                        l1 = l1.next;
                    } else {
                        result.next = l2;
                        l2 = l2.next;
                    }
                } else {
                    result.next = l1;
                    l1 = l1.next;
                }
            } else {
                if (l2 != null) {
                    result.next = l2;
                    l2 = l2.next;
                } else {
                    break;
                }
            }
            result = result.next;
        }

        return head.next;
    }

}
