package zhy2002.leetcode.solutions.climbingstairs;

/**
 *
 * //fibonacci with bottom up dp
 */
public class DpSolution implements Solution {

    @Override
    public int climbStairs(int n) {
        int[] steps = {1, 1, 2};
        if (n <= 2)
            return steps[n];
        for (int i = 3; i <= n; i++) {
            steps[i % 3] = steps[(i % 3 - 1 + 3) % 3] + steps[(i % 3 - 2 + 3) % 3];
        }
        return steps[n % 3];
    }
}
