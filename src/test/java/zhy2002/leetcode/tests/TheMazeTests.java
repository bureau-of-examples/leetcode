package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/the-maze/description/
 */
public class TheMazeTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.hasPath(
                        new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}},
                        new int[]{0, 4},
                        new int[]{4, 4}
                ),
                equalTo(true)
        );
    }

    public class Solution {

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            int m = maze.length;
            int n = maze[0].length;
            long startPos = (long) start[0] << 32 | start[1];

            Deque<Long> queue = new ArrayDeque<>();
            Set<Long> visited = new HashSet<>();
            queue.add(startPos);
            visited.add(startPos);
            while (!queue.isEmpty()) {
                long pos = queue.poll();
                int x = (int) (pos >>> 32);
                int y = (int) pos;
                if (destination[0] == x && destination[1] == y)
                    return true;

                //up
                int up = x - 1;
                while (up >= 0 && maze[up][y] == 0) {
                    up--;
                }
                up++;
                long upPos = (long) up << 32 | y;
                if (!visited.contains(upPos)) {
                    queue.add(upPos);
                    visited.add(upPos);
                }

                //down
                up = x + 1;
                while (up < m && maze[up][y] == 0) {
                    up++;
                }
                up--;
                upPos = (long) up << 32 | y;
                if (!visited.contains(upPos)) {
                    queue.add(upPos);
                    visited.add(upPos);
                }

                //left
                int left = y - 1;
                while (left >= 0 && maze[x][left] == 0) {
                    left--;
                }
                left++;
                long leftPos = (long) x << 32 | left;
                if (!visited.contains(leftPos)) {
                    queue.add(leftPos);
                    visited.add(leftPos);
                }

                //right
                left = y + 1;
                while (left < n && maze[x][left] == 0) {
                    left++;
                }
                left--;
                leftPos = (long) x << 32 | left;
                if (!visited.contains(leftPos)) {
                    queue.add(leftPos);
                    visited.add(leftPos);
                }
            }
            return false;
        }
    }
}
