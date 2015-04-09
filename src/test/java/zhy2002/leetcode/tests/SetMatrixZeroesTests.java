package zhy2002.leetcode.tests;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.setmatrixzeroes.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class SetMatrixZeroesTests {

    @Test
    public void basicTest(){

        int[][] matrix = {{1,2,3}, {4,0,5}, {6,7,0}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        assertEquals("1,0,0 0,0,0 0,0,0", Utils.intMatrixToString(matrix));

        int[][] matrix2 = {{1,2,3, 4}, {4,0,5 ,5}, {6,7, 8, 9}};
        solution.setZeroes(matrix2);
        assertEquals("1,0,3,4 0,0,0,0 6,0,8,9", Utils.intMatrixToString(matrix2));

        int[][] matrix3 = {{1,2,3, 0}, {4,4,5 ,5}, {6,7, 8, 9}, {6,7, 8, 9}};
        solution.setZeroes(matrix3);
        assertEquals("0,0,0,0 4,4,5,0 6,7,8,0 6,7,8,0", Utils.intMatrixToString(matrix3));

    }
}
