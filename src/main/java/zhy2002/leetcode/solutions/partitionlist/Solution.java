package zhy2002.leetcode.solutions.partitionlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 * Split into left and right list by maintaining their respective first and last pointers.
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode leftFirst, leftLast, rightFirst, rightLast;
        leftFirst = leftLast = rightFirst = rightLast = null;
        while (head != null) {
            if (head.val < x) {
                if (leftLast == null) {
                    leftFirst = leftLast = head;
                } else {
                    leftLast.next = head;
                    leftLast = leftLast.next;
                }
            } else {
                if (rightLast == null) {
                    rightFirst = rightLast = head;
                } else {
                    rightLast.next = head;
                    rightLast = rightLast.next;
                }
            }
            head = head.next;
        }

        if (rightLast != null)
            rightLast.next = null;

        if (leftLast != null) {
            leftLast.next = rightFirst;
            return leftFirst;
        }
        return rightFirst;
    }
}
