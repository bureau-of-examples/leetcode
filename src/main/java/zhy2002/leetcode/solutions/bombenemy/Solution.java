package zhy2002.leetcode.solutions.bombenemy;

/**
 * https://leetcode.com/problems/bomb-enemy/
 * <p>
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * <p>
 * Example:
 * <p>
 * For the given grid
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * <p>
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class Solution {

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m <= 0)
            return 0;
        int n = grid[0].length;
        if (n <= 0)
            return 0;

        int[][] counts = new int[m][n];
        int count;
        for (int i = 0; i < m; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                count = updateCount(counts, i, j, grid, count);
            }

            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                count = updateCount(counts, i, j, grid, count);
            }
        }

        for (int j = 0; j < n; j++) {
            count = 0;
            for (int i = 0; i < m; i++) {
                count = updateCount(counts, i, j, grid, count);
            }
            count = 0;
            for (int i = m - 1; i >= 0; i--) {
                count = updateCount(counts, i, j, grid, count);
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, counts[i][j]);
                }
            }
        }
        return max;
    }

    private int updateCount(int[][] counts, int i, int j, char[][] grid, int count) {
        counts[i][j] += count;
        if (grid[i][j] == 'W')
            return 0;
        if (grid[i][j] == 'E')
            return count + 1;
        return count;
    }
}
