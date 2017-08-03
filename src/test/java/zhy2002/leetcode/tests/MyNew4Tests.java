package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class MyNew4Tests {


    @Test
    public void test() {
        assertThat(
                Utils.linkedListToString(reverseKGroup(Utils.createLinkedList(1, 2, 3, 4, 5, 6, 7, 8), 3)),
                equalTo("3 2 1 6 5 4 7 8")
        );

        assertThat(
                Utils.linkedListToString(reverseKGroup(Utils.createLinkedList(1, 2, 3, 4, 5, 6, 7), 3)),
                equalTo("3 2 1 6 5 4 7")
        );
        assertThat(
                Utils.linkedListToString(reverseKGroup(Utils.createLinkedList(1, 2, 3, 4, 5, 6), 3)),
                equalTo("3 2 1 6 5 4")
        );
        assertThat(
                Utils.linkedListToString(reverseKGroup(Utils.createLinkedList(1, 2, 3, 4, 5, 6), 2)),
                equalTo("2 1 4 3 6 5")
        );
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;
        ListNode start = head;
        ListNode firstEnd = null;
        ListNode previousEnd = null;
        while (start != null) {
            ListNode end = start;
            int count = 1;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (end == null)
                break;
            ListNode nextStart = end.next;
            reverse(start, end);
            if (previousEnd != null) {
                previousEnd.next = end;
            }
            previousEnd = start;
            if (firstEnd == null) {
                firstEnd = end;
            }
            start.next = nextStart;
            start = nextStart;
        }
        return firstEnd == null ? head : firstEnd;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode reverseTail = null;
        ListNode boundary = end.next;
        while (start != boundary) {
            ListNode next = start.next;
            start.next = reverseTail;
            reverseTail = start;
            start = next;
        }
    }

    private static Node build(int[] array, int start, int end) {
        if (start > end)
            return null;
        int mid = (end - start + 1) / 2;
        Node node = new Node(array[mid]);
        node.left = build(array, start, mid - 1);
        node.right = build(array, mid + 1, end);
        return node;
    }
}
