package zhy2002.leetcode.tests;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.rotateimage.Solution;
import org.junit.Test;

import static org.junit.Assert.*;


public class RotateImageTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        int[][] matrix1 = {
                {1, 2},
                {3, 4}};
        solution.rotate(matrix1);
        assertEquals("3,1 4,2", Utils.intMatrixToString(matrix1));

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        solution.rotate(matrix2);
        assertEquals("7,4,1 8,5,2 9,6,3", Utils.intMatrixToString(matrix2));

        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        solution.rotate(matrix3);
        assertEquals("13,9,5,1 14,10,6,2 15,11,7,3 16,12,8,4", Utils.intMatrixToString(matrix3));

    }
}
