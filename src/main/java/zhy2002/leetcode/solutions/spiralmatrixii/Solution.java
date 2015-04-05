package zhy2002.leetcode.solutions.spiralmatrixii;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Do it layer by layer from outside to inside.
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        if (n < 0)
            return null;

        int[][] matrix = new int[n][];
        for (int i = 0; i < matrix.length; i++)
            matrix[i] = new int[n];

        fillSpiral(matrix, 0);
        return matrix;
    }

    public static void fillSpiral(int[][] matrix, int startRow) {
        if (startRow > (matrix.length - 1) / 2)
            return;

        int endRow = matrix.length - 1 - startRow;
        int layerSize = endRow - startRow + 1;
        int index = matrix.length * matrix.length - layerSize * layerSize + 1;

        for (int j = startRow; j <= endRow; j++)
            matrix[startRow][j] = index++;

        for (int i = startRow + 1; i <= endRow; i++)
            matrix[i][endRow] = index++;

        if (endRow != startRow)
            for (int j = endRow - 1; j >= startRow; j--)
                matrix[endRow][j] = index++;

        if (endRow != startRow)
            for (int i = endRow - 1; i > startRow; i--)
                matrix[i][startRow] = index++;

        fillSpiral(matrix, startRow + 1);

    }

}
