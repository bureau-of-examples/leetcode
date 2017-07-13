package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/number-of-islands/#/description
 */
public class NumberOfIslands2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.numIslands(new char[][]{{'1', '0', '1'}, {'1', '0', '1',}, {'1', '1', '1'}}), equalTo(1));
        assertThat(solution.numIslands(new char[][]{{'1', '0', '1'}, {'1', '0', '1'}}), equalTo(2));
        assertThat(solution.numIslands(new char[][]{{'1', '0', '1'}}), equalTo(2));
        assertThat(solution.numIslands(new char[][]{{'1'}}), equalTo(1));
    }

    public class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            if (m == 0)
                return 0;
            int n = grid[0].length;

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        mark(grid, i, j, m, n);
                    }
                }
            }
            return count;
        }

        private void mark(char[][] grid, int i, int j, int m, int n) {
            if (i < 0 || j < 0 || i >= m || j >= n)
                return;

            if (grid[i][j] != '1')
                return;

            grid[i][j] = '2';
            mark(grid, i - 1, j, m, n);
            mark(grid, i + 1, j, m, n);
            mark(grid, i, j - 1, m, n);
            mark(grid, i, j + 1, m, n);
        }
    }
}
