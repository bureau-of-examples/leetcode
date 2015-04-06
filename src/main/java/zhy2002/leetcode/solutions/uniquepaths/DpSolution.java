package zhy2002.leetcode.solutions.uniquepaths;

/**
 * Bottom up DP.
 */
public class DpSolution implements Solution {

    @Override
    public int uniquePaths(int m, int n) {
        int[] array = new int[m * n];
        for (int i = 0; i < n; i++) {//first row
            array[i] = 1;
        }

        for (int j = 1; j < m; j++) {//first col
            array[j * n] = 1;
        }

        for (int i = 1; i < n; i++) {//dp: number of ways to reach here = number of ways to reach top neighbour + number of ways to reach left neighbour.
            for (int j = 1; j < m; j++) {
                array[j * n + i] = array[(j - 1) * n + i] + array[j * n + i - 1];
            }
        }
        return array[array.length - 1];
    }
}
