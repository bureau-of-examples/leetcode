package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/palindrome-linked-list/#/description
 */
public class PalindromeLinkedList3Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        private ListNode mid;

        public boolean isPalindrome(ListNode head) {
            if (head == null)
                return true;

            mid = null;
            int len = getLen(head);
            ListNode rightStart = len % 2 == 1 ? mid.next : mid;
            rightStart = reverse(rightStart);
            return areSame(rightStart, head);
        }

        private ListNode reverse(ListNode node) {
            ListNode reverseHead = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = reverseHead;
                reverseHead = node;
                node = next;
            }
            return reverseHead;
        }

        private boolean areSame(ListNode node1, ListNode node2) {
            while (node1 != null) {
                if (node1.val != node2.val)
                    return false;
                node1 = node1.next;
                node2 = node2.next;
            }
            return true;
        }

        private int getLen(ListNode node) {
            ListNode fast = node;
            ListNode slow = node;
            int len = 0;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                len += 2;
                slow = slow.next;
            }
            if (fast != null)
                len++;
            mid = slow;
            return len;
        }

    }

}
