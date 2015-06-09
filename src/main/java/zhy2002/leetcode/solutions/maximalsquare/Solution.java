package zhy2002.leetcode.solutions.maximalsquare;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        if(m == 0)
            return 0;

        int n = matrix[0].length;
        if(n == 0)
            return 0;

        int max = 0;
        int[][] dp = new int[m][n];//dp[i][j] the max square you can build here (right bottom corner at i, j)
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            if (dp[0][j] > max) {
                max = dp[0][j];
            }
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max * max;
    }
}
