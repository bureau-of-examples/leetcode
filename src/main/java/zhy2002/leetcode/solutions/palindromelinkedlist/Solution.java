package zhy2002.leetcode.solutions.palindromelinkedlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Given a singly linked list, determine if it is a palindrome.
 * Could you do it in O(n) time and O(1) space?
 */
public class Solution {

    //find the left mid node, reverse the second half, then compare
    //1 -> 2 -> [3] -> 4 -> 5 -> 6 to 1 -> 2 -> 3 -> null and 6 -> 5 -> 4 -> 3 -> null
    //1 -> 2 -> 3 -> [4] -> 5 -> 6 -> 7 to 1 -> 2 -> 3 -> 4 -> null and 7 -> 6-> 5 -> 4 -> null
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        ListNode leftMid = findLeftMid(head);
        ListNode end = reverse(leftMid);
        leftMid.next = null;
        return compare(head, end);

    }

    private boolean compare(ListNode head, ListNode end) {
        while (head != null && end != null){
            if(head.val != end.val){
                return false;
            }
            head = head.next;
            end = end.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode previous = node;
        ListNode next = node.next;

        while (next != null){
            ListNode nextNext = next.next;
            next.next = previous;
            previous = next;
            next = nextNext;
        }

        return previous;
    }

    private ListNode findLeftMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            fast = fast.next;
            if(fast == null)
                break;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


}
