package zhy2002.leetcode.solutions.uniquepathsii;

/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        if(obstacleGrid[0][0] == 1)
            return 0;

        int[] row = new int[obstacleGrid[0].length];
        row[0] = 1;

        for(int j=1; j<row.length; j++){//calc row 1
            if(row[j-1] == 0 || obstacleGrid[0][j] == 1)
                row[j] = 0;
            else
                row[j] = 1;
        }

        for(int i=1; i<obstacleGrid.length; i++){ //calc row by row
            if(row[0] == 1 && obstacleGrid[i][0] == 1)
                row[0] = 0;
            boolean allZero = row[0] == 0;
            for(int j=1; j < row.length; j++){
                if(obstacleGrid[i][j] == 1)
                    row[j] = 0;
                else
                    row[j] = row[j] + row[j-1];
                if(allZero)
                    allZero = row[j] == 0;
            }
            if(allZero)
                return 0;
        }
        return row[row.length - 1];

    }
}
