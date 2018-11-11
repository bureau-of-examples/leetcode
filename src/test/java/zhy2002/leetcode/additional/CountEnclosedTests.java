package zhy2002.leetcode.additional;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountEnclosedTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.countEnclosed(new char[][] {
                {'X','X','X'},
                {'X','W','X'},
                {'X','X','X'}
        }), equalTo(1));

        assertThat(solution.countEnclosed(new char[][] {
                {'X','X','X'},
                {'X','W','X'},
                {'X','X','W'}
        }), equalTo(1));

        assertThat(solution.countEnclosed(new char[][] {
                {'X','X','X', 'X'},
                {'X','W','X', 'X'},
                {'X','X','W', 'X'},
                {'X','X','W', 'X'}
        }), equalTo(1));

        assertThat(solution.countEnclosed(new char[][] {
                {'X','X','X', 'X'},
                {'X','W','W', 'X'},
                {'X','X','W', 'X'},
                {'X','X','X', 'X'}
        }), equalTo(3));
    }

    private static class Solution {

        public int countEnclosed(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            for (int j = 0; j < n; j++) {
                dfs(matrix, 0, j);
                dfs(matrix, m - 1, j);
            }
            for (int i = 0; i < m; i++) {
                dfs(matrix, i, 0);
                dfs(matrix, i, n - 1);
            }

            int count = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (matrix[i][j] == 'W') {
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] matrix, int i, int j) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (matrix[i][j] == 'W') {
                matrix[i][j] = 'w';
                dfs(matrix, i - 1, j);
                dfs(matrix, i, j + 1);
                dfs(matrix, i + 1, j);
                dfs(matrix, i, j - 1);
            }
        }
    }
}
