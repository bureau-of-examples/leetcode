package zhy2002.leetcode.solutions.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null)
            return null;

        List<Integer> result = new ArrayList<>();
        if (matrix.length > 0)
            spiralOrder(result, matrix, 0, 0);//left top of layer
        return result;
    }

    private static void spiralOrder(List<Integer> result, int[][] matrix, int startRow, int startCol) {

        if (startRow > (matrix.length - 1) / 2)
            return;

        if (startCol > (matrix[0].length - 1) / 2)
            return;

        int endRow = matrix.length - 1 - startRow;
        int endCol = matrix[0].length - 1 - startCol;

        for (int j = startCol; j <= endCol; j++)
            result.add(matrix[startRow][j]);

        for (int i = startRow + 1; i <= endRow; i++)
            result.add(matrix[i][endCol]);

        if (endRow != startRow)
            for (int j = endCol - 1; j >= startCol; j--)
                result.add(matrix[endRow][j]);

        if (endCol != startCol)
            for (int i = endRow - 1; i > startRow; i--)
                result.add(matrix[i][startCol]);

        spiralOrder(result, matrix, startRow + 1, startCol + 1);

    }
}
