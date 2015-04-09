package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.searcha2dmatrix.Solution;

import static org.junit.Assert.*;

public class SearchA2DMatrixTests {

    @Test
    public void basicTest() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        Solution solution = new Solution();
        assertTrue(solution.searchMatrix(matrix, 1));
        assertTrue(solution.searchMatrix(matrix, 5));
        assertTrue(solution.searchMatrix(matrix, 20));
        assertTrue(solution.searchMatrix(matrix, 30));
        assertTrue(solution.searchMatrix(matrix, 50));
        assertFalse(solution.searchMatrix(matrix, -1));
        assertFalse(solution.searchMatrix(matrix, 55));
        assertFalse(solution.searchMatrix(matrix, 17));

        int[][] matrix2 = {{10, 15, 18}, {20, 21, 22}, {34, 55, 66}};
        assertTrue(solution.searchMatrix(matrix2, 15));
        assertTrue(solution.searchMatrix(matrix2, 21));
        assertTrue(solution.searchMatrix(matrix2, 66));
        assertFalse(solution.searchMatrix(matrix2, 40));
    }
}
