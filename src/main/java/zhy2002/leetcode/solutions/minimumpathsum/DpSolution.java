package zhy2002.leetcode.solutions.minimumpathsum;

/**
 * Bottom up DP.
 */
public class DpSolution implements Solution {

    @Override
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        //assume all rows has the same number of columns
        int m = grid.length;
        int n = grid[0].length;

        int[] array = new int[m * n];
        int min = 0;
        for (int i = 0; i < n; i++) {//first row
            min = array[i] = min + grid[0][i];
        }

        min = grid[0][0];
        for (int j = 1; j < m; j++) {//first col
            min = array[j * n] = min + grid[j][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                array[j * n + i] = Math.min(array[(j - 1) * n + i], array[j * n + i - 1]) + grid[j][i];
            }
        }
        return array[array.length - 1];
    }

}
