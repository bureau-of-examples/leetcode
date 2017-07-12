package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/reverse-linked-list/#/description
 */
public class ReverseLinkedList2Tests {

    @Test
    public void test() {
        RecSolution solution = new RecSolution();
        assertThat(
                Utils.linkedListToString(solution.reverseList(Utils.createLinkedList(2, 3))),
                equalTo("3 2")
        );
        assertThat(
                Utils.linkedListToString(solution.reverseList(Utils.createLinkedList(1, 2, 3))),
                equalTo("3 2 1")
        );
    }

    public class RecSolution {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            ListNode next = head.next;
            head.next = null;
            return reverse(next, head);
        }

        private ListNode reverse(ListNode next, ListNode head) {
            if (next == null)
                return head;
            ListNode nextNext = next.next;
            next.next = head;
            return reverse(nextNext, next);
        }
    }

    public class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;

            ListNode previous = head;
            ListNode current = head.next;
            head.next = null;
            while (current != null) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }
}
