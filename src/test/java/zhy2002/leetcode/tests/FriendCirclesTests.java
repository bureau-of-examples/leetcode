package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/friend-circles/#/description
 */
public class FriendCirclesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findCircleNum(new int[][]{
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}
                }),
                equalTo(1)
        );

        assertThat(
                solution.findCircleNum(new int[][]{
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 1, 1}
                }),
                equalTo(1)
        );
    }


    public class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;

            int count = 0;
            boolean[] found = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (found[i])
                    continue;
                count++;
                addAll(found, i, M, n);
            }
            return count;
        }

        private void addAll(boolean[] found, int i, int[][] M, int n) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer val = queue.poll();
                found[val] = true;
                for (int j = 0; j < n; j++) {
                    if (M[val][j] == 1 && !found[j]) {
                        queue.add(j);
                    }
                }
            }
        }
    }
}
