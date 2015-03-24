package zhy2002.leetcode.solutions.addtwonumbers;

import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.twosum.*;

/**
 * Calculate result one digit at a time. No sentinel is used.
 */
public class NoSentinelSolution implements Solution {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode result = null;//head of result list
        ListNode previous = null;//used to link next result node
        while (l1 != null || l2 != null || carry != 0){//more result digit
            //fetch operands
            int left = 0, right = 0;
            if(l1 != null){
                left = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                right = l2.val;
                l2 = l2.next;
            }
            int val = left + right + carry;
            carry = val / 10;
            val = val % 10;

            if(previous == null){
                result = new ListNode(val);
                previous = result;
            } else {
                previous.next = new ListNode(val);
                previous = previous.next;
            }
        }

        return result;
    }
}
