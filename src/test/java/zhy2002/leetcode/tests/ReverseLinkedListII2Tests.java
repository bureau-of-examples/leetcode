package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/#/description
 */
public class ReverseLinkedListII2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(
                Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1, 2, 3, 4), 1, 4)),
                equalTo("4 3 2 1")
        );

        assertThat(
                Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1, 2, 3, 4), 1, 3)),
                equalTo("3 2 1 4")
        );

        assertThat(
                Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1, 2, 3, 4), 2, 3)),
                equalTo("1 3 2 4")
        );
    }

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n)
                return head;

            ListNode sentinel = new ListNode(-1);
            sentinel.next = head;

            ListNode mPrev = sentinel;
            ListNode nPrev = sentinel;
            for (int i = 1; i < n; i++) {
                nPrev = nPrev.next;
                if (i > n - m) {
                    mPrev = mPrev.next;
                }
            }

            ListNode mNode = mPrev.next;
            mPrev.next = null;
            ListNode nNode = nPrev.next;
            ListNode nNext = nNode.next;
            nNode.next = null;
            mPrev.next = reverse(mNode);
            mNode.next = nNext;
            return sentinel.next;
        }

        private ListNode reverse(ListNode node) {
            ListNode reverseHead = node;
            ListNode next = node.next;
            while (next != null) {
                ListNode nextNext = next.next;
                next.next = reverseHead;
                reverseHead = next;
                next = nextNext;
            }
            return reverseHead;
        }
    }

}
