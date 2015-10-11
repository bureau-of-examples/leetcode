package zhy2002.leetcode.solutions.intersectionoftwolinkedlists;

import org.jetbrains.annotations.Nullable;
import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {

    @Nullable
    public ListNode getIntersectionNode( @Nullable ListNode headA, @Nullable ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode pointer1 = headA.next;
        int count = 1;
        while (pointer1 != null) {
            count++;
            pointer1 = pointer1.next;
        }

        pointer1 = headB;
        while (pointer1 != null) {
            count--;
            pointer1 = pointer1.next;
        }

        //count = len(headA) - len(headB)
        ListNode pointer2; //this is the shorter one
        if (count >= 0) {
            pointer1 = headA;
            pointer2 = headB;
        } else {
            pointer1 = headB;
            pointer2 = headA;
            count = -count;
        }

        for (int i = 0; i < count; i++) {
            pointer1 = pointer1.next;
        }
        //now the two pointers have the same distance to end
        while (pointer1 != null && pointer2 != null) {
            if (pointer1 == pointer2)
                return pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return null;

    }
}
