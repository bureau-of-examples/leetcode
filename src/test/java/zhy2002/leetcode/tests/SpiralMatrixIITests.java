package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.spiralmatrixii.Solution;
import static org.junit.Assert.*;

public class SpiralMatrixIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("1",Utils.intMatrixToString(solution.generateMatrix(1)));
        assertEquals("1,2 4,3",Utils.intMatrixToString(solution.generateMatrix(2)));
        assertEquals("1,2,3 8,9,4 7,6,5",Utils.intMatrixToString(solution.generateMatrix(3)));
        assertEquals("1,2,3,4 12,13,14,5 11,16,15,6 10,9,8,7",Utils.intMatrixToString(solution.generateMatrix(4)));
    }
}
