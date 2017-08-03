package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class MyNew3Tests {

    @Test
    public void test3() {
        System.out.println(solve2(4, new int[]{1, 2, 3}, new int[]{4, 5, 1}));
    }

    private static int solve2(int w, int[] values, int[] weights) {
        int n = values.length;
        int[][] dp = new int[w + 1][n + 1]; //dp[i][j] max value when limit is i using the first j items
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                int max = 0;
                int itemWeight = weights[j - 1];
                if (itemWeight <= i) {
                    max = Math.max(max, values[j - 1] + dp[i - itemWeight][j - 1]);
                }
                max = Math.max(max, dp[i][j - 1]);
                dp[i][j] = max;
            }
        }
        return dp[w][n];
    }

    @Test
    public void test() {
        assertThat(solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}), equalTo(9));
        assertThat(solve(new int[]{1, 2, 3, 5}), equalTo(4));
    }

    private static int solve(int[] array) {
        int index = 0;
        while (index < array.length) {
            if (array[index] == index + 1) {
                index++;
            } else if (array[index] <= array.length) {
                swap(array, index, array[index] - 1);
            } else {
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1)
                return i + 1;
        }
        throw new RuntimeException("Not found");
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void test2() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(3);
        Node result = deleteAllOccurances(head, 2);
        System.out.println();
    }

    Node deleteAllOccurances(Node head, int x) {
        Node sentinel = new Node(-1);
        sentinel.next = head;
        Node previous = sentinel;
        Node current = sentinel.next;
        while (current != null) {
            if (current.data == x) {
                previous.next = current.next;
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
        previous.next = null;
        return sentinel.next;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

}
