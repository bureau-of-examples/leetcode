package zhy2002.leetcode.solutions.removelinkedlistelements;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode previous, current, newHead;
        newHead = head;
        while (true) {
            if (newHead == null)
                return null;
            if (newHead.val == val)
                newHead = newHead.next;
            else
                break;
        }
        current = newHead.next;
        previous = newHead;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
                current = previous.next;

            } else {
                previous = current;
                current = current.next;
            }
        }
        return newHead;
    }
}
