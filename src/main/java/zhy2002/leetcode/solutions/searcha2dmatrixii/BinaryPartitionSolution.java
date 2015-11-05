package zhy2002.leetcode.solutions.searcha2dmatrixii;

/**
 * Given a matrix, search in the middle row.
 * If find it, good. If not, find the insert position.
 * Then we can partition the matrix into 4 blocks. Left top and bottom right are eliminated and we can continue to search in the other two.
 */
public class BinaryPartitionSolution implements Solution {

    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;

        return search(matrix, 0, 0, m - 1, n - 1, target);
    }


    private boolean search(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd, int target) {
        if (rowEnd < rowStart || colEnd < colStart)
            return false;

        //binary search in middle row
        int midRow = (rowStart + rowEnd) >>> 1;
        int start = colStart, end = colEnd;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (matrix[midRow][mid] == target) {
                return true;
            }
            if (matrix[midRow][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        //target in (end, start)
        if (search(matrix, rowStart, start, midRow - 1, colEnd, target)) //right top
            return true;

        return search(matrix, midRow + 1, colStart, rowEnd, end, target); //left bottom
    }
}
