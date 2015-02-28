package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.solutions.nqueensii.Solution;

import static org.junit.Assert.*;

public class NQueensIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(1, solution.totalNQueens(1));
        assertEquals(0, solution.totalNQueens(2));
        assertEquals(0, solution.totalNQueens(3));
        assertEquals(2, solution.totalNQueens(4));
        assertEquals(10, solution.totalNQueens(5));
        assertEquals(4, solution.totalNQueens(6));
        assertEquals(40, solution.totalNQueens(7));
        assertEquals(92, solution.totalNQueens(8));

    }
}
