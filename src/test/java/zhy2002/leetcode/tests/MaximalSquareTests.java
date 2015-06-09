package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.maximalsquare.Solution;

import static org.junit.Assert.*;

public class MaximalSquareTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        char[][] mat1 = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        assertEquals(4, solution.maximalSquare(mat1));

        char[][] mat2 = new char[][] {
                {'1','0','1','0','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','1','1','1','0'},
                {'1','1','1','0','0'}};
        assertEquals(9, solution.maximalSquare(mat2));
    }
}
