package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.uniquebinarsearchtrees.Solution;
import static org.junit.Assert.*;

public class UniqueBinarySearchTreesTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(1, solution.numTrees(0));
        assertEquals(1, solution.numTrees(1));
        assertEquals(2, solution.numTrees(2));
        assertEquals(5, solution.numTrees(3));
        assertEquals(14, solution.numTrees(4));
        assertEquals(42, solution.numTrees(5));
    }
}
