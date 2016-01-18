package zhy2002.leetcode.solutions.oddevenlinkedlist;

import zhy2002.leetcode.common.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null;

        ListNode oddHead = head;
        ListNode oddTail = oddHead;

        if(head.next == null)
            return head;

        head = head.next;
        ListNode evenHead = head;
        ListNode evenTail = evenHead;
        head = head.next;

        boolean isOdd = true;
        while (head != null) {

            if (isOdd) {
                oddTail.next = head;
                oddTail = head;
                evenTail.next = null;
            } else {
                evenTail.next = head;
                evenTail = head;
                oddTail.next = null;
            }
            head = head.next;
            isOdd = !isOdd;
        }

        oddTail.next = evenHead;
        return oddHead;
    }
}
