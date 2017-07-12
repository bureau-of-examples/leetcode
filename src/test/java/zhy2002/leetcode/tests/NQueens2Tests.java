package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * https://leetcode.com/problems/n-queens/#/description
 */
public class NQueens2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();

        List<List<String>> result = solution.solveNQueens(4);
        assertThat(result, hasSize(2));

        result = solution.solveNQueens(8);
        assertThat(result, hasSize(92));
    }

    public class Solution {
        private List<List<String>> result;

        public List<List<String>> solveNQueens(int n) {
            result = new ArrayList<>();
            solve(new ArrayList<>(), new boolean[n], 0, n);
            return result;
        }

        private void solve(List<String> buffer, boolean[] occupied, int i, int n) {
            if (i == n) {
                result.add(new ArrayList<>(buffer));
            }

            for (int j = 0; j < n; j++) {
                if (occupied[j] || hasDiagonal(buffer, i, j, n))
                    continue;

                occupied[j] = true;
                buffer.add(makeString(j, n));
                solve(buffer, occupied, i + 1, n);
                occupied[j] = false;
                buffer.remove(buffer.size() - 1);
            }
        }

        private boolean hasDiagonal(List<String> buffer, int i, int j, int n) {
            int left = j, right = j;
            for (int index = i - 1; index >= 0; index--) {
                left--;
                right++;
                if (left >= 0 && buffer.get(index).charAt(left) == 'Q')
                    return true;
                if (right < n && buffer.get(index).charAt(right) == 'Q')
                    return true;
            }
            return false;
        }

        private String makeString(int j, int n) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < n; index++) {
                if (index == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            return sb.toString();
        }

    }
}
