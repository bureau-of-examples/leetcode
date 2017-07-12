package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 */
public class IntersectionOfTwoLinkedLists2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();

        ListNode headA = new ListNode(10);
        ListNode headB = new ListNode(20);
        headB.next = headA;

        assertThat(solution.getIntersectionNode(headA, headB), sameInstance(headA));
        assertThat(solution.getIntersectionNode(headA, headA), sameInstance(headA));
        assertThat(solution.getIntersectionNode(new ListNode(10), new ListNode(20)), nullValue());
        assertThat(solution.getIntersectionNode(null, null), nullValue());
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int countA = count(headA);
            int countB = count(headB);

            if (countA == 0 || countB == 0)
                return null;

            if (countA < countB) {//swap
                int temp = countA;
                countA = countB;
                countB = temp;
                ListNode head = headA;
                headA = headB;
                headB = head;
            }

            ListNode nodeA = advance(headA, countA - countB);
            ListNode nodeB = headB;
            while (nodeB != null) {
                if (nodeA == nodeB)
                    return nodeA;
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return null;
        }

        private ListNode advance(ListNode head, int count) {
            for (int i = 0; i < count; i++) {
                head = head.next;
            }
            return head;
        }

        private int count(ListNode head) {
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }
            return count;
        }
    }
}
