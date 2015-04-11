package zhy2002.leetcode.solutions.reverselinkedlistii;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class Solution {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null)
            return head;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prevM = sentinel;
        for (int i = m; i > 1; i--) {//m-1 times
            prevM = prevM.next;
        }

        ListNode start, end;
        start = end = prevM.next;
        for (int i = m; i < n; i++) {
            prevM.next = end.next;
            ListNode nextNext = prevM.next.next;
            prevM.next.next = start;
            end.next = nextNext;
            start = prevM.next;
        }

        return sentinel.next;
    }
}
