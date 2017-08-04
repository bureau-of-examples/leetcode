package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

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
    public void test4() {
        printK(new int[]{5, 2, 1, 3, 2}, 4);
    }

    private static void printK(int[] array, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int[] topK = new int[k + 1];
        int nextIndex = 0;
        for (int num : array) {
            int newCount = counts.getOrDefault(num, 0) + 1;
            counts.put(num, newCount);

            int pos = find(topK, nextIndex, num);
            topK[pos] = num;
            if (pos < k && pos == nextIndex) {
                nextIndex++;
            }
            bubble(topK, pos, counts);

            for (int i = 0; i < nextIndex; i++) {
                System.out.print(topK[i] + " ");
            }
        }
    }

    private static int find(int[] topK, int len, int target) {
        int i = 0;
        for (; i < len; i++) {
            if (topK[i] == target)
                break;
        }
        return i;
    }

    private static void bubble(int[] topK, int pos, Map<Integer, Integer> counts) {
        while (pos > 0) {
            if (counts.get(topK[pos]) > (int) counts.get(topK[pos - 1]) ||
                    counts.get(topK[pos]) == (int) counts.get(topK[pos - 1]) && topK[pos] < topK[pos - 1]
                    ) {
                int temp = topK[pos - 1];
                topK[pos - 1] = topK[pos];
                topK[pos] = temp;
                pos--;
            } else {
                break;
            }
        }
    }


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
