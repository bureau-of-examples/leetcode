package zhy2002.leetcode.solutions.linkedlistcycle;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Use two pointers p1 and p2 starting from head node.
 * Every time p1 advance 1 step and p2 2 steps.
 * If there is a cycle p1 will equal p2 eventually otherwise you will trace to a null value.
 */
public class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode pointer1, pointer2;
        pointer1 = pointer2 = head;

        do {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            if (pointer2 == null)
                return false;
            else
                pointer2 = pointer2.next;
            if (pointer2 == null)
                return false;
        } while (pointer1 != pointer2);

        return true;

    }
}
