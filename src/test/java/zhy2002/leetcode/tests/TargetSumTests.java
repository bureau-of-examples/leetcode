package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/target-sum/#/description
 */
public class TargetSumTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3),
                equalTo(5)
        );
    }

    public class Solution2 {

        private int count;

        public int findTargetSumWays(int[] nums, int S) {
            count = 0;
            solve(nums, 0, 0, S);
            return count;
        }

        private void solve(int[] nums, int size, int sum, int S) {
            if (size == nums.length) {
                if (sum == S) {
                    count++;
                }
                return;
            }
            solve(nums, size + 1, sum + nums[size], S);
            solve(nums, size + 1, sum - nums[size], S);
        }
    }

    public class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int[][] dp = new int[nums.length][2001]; //dp[i][j] = # of ways to use nums[0] to nums[i] to get sum[j]
            dp[0][nums[0] + 1000] = 1;
            dp[0][-nums[0] + 1000] += 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = -1000; j <= 1000; j++) {
                    if (dp[i - 1][j + 1000] > 0) {
                        dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                        dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                    }
                }
            }
            return dp[nums.length - 1][S + 1000];
        }
    }
}
