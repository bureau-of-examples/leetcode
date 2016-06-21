package zhy2002.leetcode.solutions.rangesumquery2dmutable;

/**
 * https://leetcode.com/problems/range-sum-query-2d-mutable/
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p>
 * Example:
 * <p>
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * <p>
 * Note:
 * <p>
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class NumMatrix {

    private int[][] bitGrid;
    private int[][] matrix;
    private int rowCount;
    private int colCount;

    public NumMatrix(int[][] matrix) {
        rowCount = matrix.length;
        if (rowCount > 0) {
            colCount = matrix[0].length;
        }
        this.matrix = new int[rowCount][colCount];
        bitGrid = new int[rowCount + 1][colCount + 1];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                update(i, j, matrix[i][j]);
            }
        }

    }

    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row + 1; i <= rowCount; i += (i & -i)) {
            for (int j = col + 1; j <= colCount; j += (j & -j)) {
                bitGrid[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
    }

    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= (i & -i)) {
            for (int j = col; j > 0; j -= (j & -j)) {
                sum += bitGrid[i][j];
            }
        }
        return sum;
    }
}


