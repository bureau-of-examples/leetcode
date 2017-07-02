package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class AssignCookiesTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.findContentChildren(
                new int[]{10, 9, 8, 7, 10, 9, 8, 7},
                new int[]{10, 9, 8, 7}
        ), equalTo(4));

        assertThat(solution.findContentChildren(
                new int[]{1, 2, 3},
                new int[]{1, 1}
        ), equalTo(1));

        assertThat(solution.findContentChildren(
                new int[]{10, 9, 8, 7},
                new int[]{5, 6, 7, 8}
        ), equalTo(2));
    }

    public class Solution {

        public int findContentChildren(int[] g, int[] s) {
            PriorityQueue<Integer> queueG = new PriorityQueue<>();
            for (int i : g) {
                queueG.add(i);
            }
            PriorityQueue<Integer> queueS = new PriorityQueue<>();
            for (int i : s) {
                queueS.add(i);
            }

            int count = 0;
            while (!queueG.isEmpty() && !queueS.isEmpty()) {
                if (queueG.peek() <= queueS.peek()) {
                    queueG.poll();
                    queueS.poll();
                    count++;
                } else {
                    queueS.poll();
                }
            }
            return count;
        }
    }

}
