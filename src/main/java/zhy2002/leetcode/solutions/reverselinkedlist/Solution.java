package zhy2002.leetcode.solutions.reverselinkedlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode current, previous;
        previous = head;
        current = previous.next;
        previous.next = null;
        while (current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
