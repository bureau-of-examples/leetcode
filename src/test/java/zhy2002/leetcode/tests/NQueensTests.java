package zhy2002.leetcode.tests;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.nqueens.Solution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NQueensTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(1, solution.solveNQueens(1).size());
        assertEquals(0, solution.solveNQueens(2).size());
        assertEquals(0, solution.solveNQueens(3).size());
        List<String[]> solution4 = solution.solveNQueens(4);
        assertEquals(2,solution4.size());
        List<String> results = new ArrayList<>();
        for(String[] board : solution4){
            assert results.add(Utils.listToString(Arrays.asList(board)));
        }
        assertTrue(results.contains(".Q.. ...Q Q... ..Q."));
        assertTrue(results.contains("..Q. Q... ...Q .Q.."));
        assertEquals(10, solution.solveNQueens(5).size());
        assertEquals(4, solution.solveNQueens(6).size());
        assertEquals(40, solution.solveNQueens(7).size());
        assertEquals(92, solution.solveNQueens(8).size());
    }
}
