package zhy2002.leetcode.solutions.setmatrixzeroes;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;

        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        //assume all rows have the same number of columns

        boolean setFitstRowTo0 = false, setFirstColTo0 = false;
        if (matrix[0][0] == 0) {
            setFitstRowTo0 = true;
            setFirstColTo0 = true;
        } else {
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0)
                    setFirstColTo0 = true;
            }

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0)
                    setFitstRowTo0 = true;
            }
        }

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

        if (setFirstColTo0)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;

        if (setFitstRowTo0)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;

    }

}
