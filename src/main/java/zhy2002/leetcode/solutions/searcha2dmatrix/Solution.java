package zhy2002.leetcode.solutions.searcha2dmatrix;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * "The first integer of each row is greater than the last integer of the previous row."
 * Binary search.
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0)
            return false;

        //assume all rows has n columns
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int rowMid = mid / n;
            int colMid = mid % n;
            if (matrix[rowMid][colMid] == target)
                return true;

            if (start == end)
                break;

            if (matrix[rowMid][colMid] > target)
                end = mid - 1;
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}
