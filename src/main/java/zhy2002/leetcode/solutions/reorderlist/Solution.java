package zhy2002.leetcode.solutions.reorderlist;

import zhy2002.leetcode.common.ListNode;


/**
 * https://oj.leetcode.com/problems/reorder-list/
 * Split the list in the middle, [start, mid], (mid, end], then reverse the second list and then merge together.
 */
public class Solution {
    public void reorderList(ListNode head) {

        if(head == null)
            return;

        //break in middle
        ListNode slow = head;
        ListNode fast = head.next;
        int count = 1;
        while (fast != null){
            fast = fast.next;
            count++;
            if(count % 2 == 1){
                slow = slow.next;
            }
        }

        //reverse second half
        ListNode previous = null;
        ListNode secondHalf = slow.next;
        while (secondHalf != null){
            ListNode next = secondHalf.next;
            secondHalf.next = previous;
            previous = secondHalf;
            secondHalf = next;
        }

        //merge previous to head
        ListNode current = head;
        ListNode next = previous;
        while (current != null){
             ListNode temp = current.next;
            current.next = next;
            current = next;
            next = temp;
        }
    }
}
