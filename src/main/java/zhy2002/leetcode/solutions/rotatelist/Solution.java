package zhy2002.leetcode.solutions.rotatelist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int n) {

        if(head == null || head.next == null || n == 0)
            return head;

        ListNode fast = head;
        int fastIndex = 0;
        ListNode slow = null;

        do{
            fast = fast.next;
            if(fast == null) {//wrap
                fast = head;
                n %= fastIndex + 1;
                if(n == 0)
                    return head;
                fastIndex = 0;
            } else {
                fastIndex++;
            }

            if(fastIndex >= n){
                if(slow == null){
                    slow = head;
                } else {
                    slow = slow.next;
                }
            }
        } while (fast.next != null || slow == null);

        fast.next = head;
        ListNode result = slow.next;
        slow.next = null;
        return result;
    }
}
