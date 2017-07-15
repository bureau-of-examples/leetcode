package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class PalindromeLinkedList2Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null)
                return true;

            ListNode mid = findMid(head);
            ListNode end = reverse(mid);

            return compare(end, head);
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast != null) {
                slow = slow.next;
            }

            return slow;
        }

        private ListNode reverse(ListNode start) {
            ListNode reversedHead = start;
            ListNode next = start.next;
            start.next = null;

            while (next != null) {
                ListNode nextNext = next.next;
                next.next = reversedHead;
                reversedHead = next;
                next = nextNext;
            }

            return reversedHead;
        }

        private boolean compare(ListNode node1, ListNode node2) {
            while (node1 != null) {
                if (node1.val != node2.val)
                    return false;
                node1 = node1.next;
                node2 = node2.next;
            }

            return true;
        }
    }

}
