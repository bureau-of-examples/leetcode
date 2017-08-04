package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 */
public class OutOfBoundaryPathsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findPaths(2, 2, 2, 0, 0), equalTo(6));
    }

    public class Solution {

        private Map<String, Integer> cache = new HashMap<>();

        public int findPaths(int m, int n, int N, int i, int j) {
            cache.clear();
            return solve(m, n, N, i, j);
        }

        private int solve(int m, int n, int N, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n)
                return 1;
            if (N == 0)
                return 0;
            String key = N + "," + i + "," + j;
            if (cache.containsKey(key))
                return cache.get(key);
            int result = solve(m, n, N - 1, i + 1, j);
            result = (result + solve(m, n, N - 1, i - 1, j)) % 1000000007;
            result = (result + solve(m, n, N - 1, i, j + 1)) % 1000000007;
            result = (result + solve(m, n, N - 1, i, j - 1)) % 1000000007;
            cache.put(key, result);
            return result;
        }
    }

}
