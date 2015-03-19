package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.maximalrectangle.Solution;

import static org.junit.Assert.*;

public class MaximalRectangleTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        char[][] matrix = {{}};
        int result = solution.maximalRectangle(matrix);
        assertEquals(0, result);

        matrix = new char[][]{{'0'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(0, result);

        matrix = new char[][]{{'1'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(1, result);

        matrix = new char[][]{{'1', '1'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(2, result);

        matrix = new char[][]{{'1', '1', '0', '1'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(2, result);

        matrix = new char[][]{{'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '0'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(6, result);

        matrix = new char[][]{{'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(9, result);

        matrix = new char[][]{{'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(3, result);

        matrix = new char[][]{{'1', '1', '0'}, {'1', '1', '1'}, {'0', '1', '1'}, {'1','1','1'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(6, result);

        matrix = new char[][]{{'0', '0', '0'}, {'0', '1', '0'}, {'0', '0', '0'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(1, result);

        matrix = new char[][]{{'0', '0', '1', '0'}, {'0', '1', '0', '0'}, {'0', '0', '1', '1'}, {'0', '0', '1', '0'}};
        result = solution.maximalRectangle(matrix);
        assertEquals(2, result);

    }

    @Test
    public void failedOJTest(){
        Solution solution = new Solution();
        char[][] matrix = {{'1', '0'}};
        int result = solution.maximalRectangle(matrix);
        assertEquals(1, result);
    }
}
