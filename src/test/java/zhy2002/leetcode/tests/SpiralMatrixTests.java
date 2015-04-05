package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.spiralmatrix.Solution;
import static org.junit.Assert.*;


public class SpiralMatrixTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("1,2,3,4,8,12,11,10,9,5,6,7", Utils.integersToString(solution.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}})));

        assertEquals("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10", Utils.integersToString(solution.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}})));

        assertEquals("1,2,3,4,8,7,6,5", Utils.integersToString(solution.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8}})));
    }
}
