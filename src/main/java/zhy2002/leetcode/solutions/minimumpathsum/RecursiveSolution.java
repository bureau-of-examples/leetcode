package zhy2002.leetcode.solutions.minimumpathsum;

import java.util.HashMap;

/**
 * Top down DP.
 */
public class RecursiveSolution implements Solution {


    private final HashMap<Long, Integer> minMap = new HashMap<>();

    @Override
    public int minPathSum(int[][] grid) {
        minMap.clear();
        return minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSum(int[][] grid, int row, int col){

        if(row < 0 || col < 0)
            return 0;

        Long key = (long)row << 32 | col & 0xFFFFFFFFL;
        Integer result = minMap.get(key);
        if(result != null)
            return result;

        int val;
        if(row == 0){
            val = minPathSum(grid, row, col - 1) + grid[row][col];
        } else if(col == 0){
            val = minPathSum(grid, row - 1, col) + grid[row][col];
        } else {
            val = Math.min(minPathSum(grid, row - 1, col), minPathSum(grid, row, col - 1)) + grid[row][col];
        }

        minMap.put(key, val);
        return val;

    }
}
