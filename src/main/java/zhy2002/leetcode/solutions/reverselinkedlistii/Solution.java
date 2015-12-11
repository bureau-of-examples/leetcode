package zhy2002.leetcode.solutions.reverselinkedlistii;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Solution {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null)
            return head;
        //locate the previous node of the starting point
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prevM = sentinel;
        for (int i = m; i > 1; i--) {//m-1 times
            prevM = prevM.next;
        }

        ListNode start, end; //invariant - nodes between start and end are reversed
        start = end = prevM.next;
        for (int i = m; i < n; i++) {  //reverse edges between m and n
            prevM.next = end.next; //will point the the end point when loop finishes
            ListNode nextNext = prevM.next.next;
            prevM.next.next = start;
            end.next = nextNext;
            start = prevM.next;
        }

        return sentinel.next;
    }
}
