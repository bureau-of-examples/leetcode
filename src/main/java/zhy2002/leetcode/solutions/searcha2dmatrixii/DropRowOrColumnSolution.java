package zhy2002.leetcode.solutions.searcha2dmatrixii;

/**
 * from the top right cornor, each comparison drops a column or a row.
 * Runs in O(m+n).
 */
public class DropRowOrColumnSolution implements Solution {
    @Override
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        if(n == 0)
            return false;

        int i = 0, j = n-1;
        while (i < m && j >=0){
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
