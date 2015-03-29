package zhy2002.leetcode.tests;

import java.util.List;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.foursum.JoinSumOfTwoSolution;
import zhy2002.leetcode.solutions.foursum.Solution;
import zhy2002.leetcode.solutions.foursum.TwoPointersSolution;

import static org.junit.Assert.*;

public class FourSumTests {

    @Test
    public void twoPointersBasicTest(){
        basicTest(new TwoPointersSolution());
    }

    @Test
    public void twoPointersDuplicateTest(){
        duplicateTest(new TwoPointersSolution());
    }

    @Test
    public void referenceBasicTest(){
        basicTest(new JoinSumOfTwoSolution());
    }

    @Test
    public void referenceDuplicateTest(){
        duplicateTest(new JoinSumOfTwoSolution());
    }

    private void basicTest(Solution solution){

        List<List<Integer>> result = solution.fourSum(new int[]{0, 0}, 4);
        assertEquals(0, result.size());

        result = solution.fourSum(new int[]{0, 0, 1, 1}, 4);
        assertEquals(0, result.size());

        result = solution.fourSum(new int[]{1, 1, 1, 1}, 4);
        assertEquals(1, result.size());
        String str = Utils.listOfListToString(result);
        assertTrue(str.contains("[1,1,1,1]"));

        result = solution.fourSum(new int[]{1, 1, 2, 1, 1}, 5);
        assertEquals(1, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[1,1,1,2]"));

        result = solution.fourSum(new int[]{1, 1, 2, 1, 1, 3, 0}, 5);
        assertEquals(2, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[0,1,1,3]"));
        assertTrue(str.contains("[1,1,1,2]"));

        result = solution.fourSum(new int[]{-5, 2, -1, 3, 7}, -1);
        assertEquals(1, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[-5,-1,2,3]"));

        result = solution.fourSum(new int[]{-5, 2, -1, 3, 7}, -2);
        assertEquals(0, result.size());

        result = solution.fourSum(new int[]{-1,2,2,-5,0,-1,4}, 3);
        assertEquals(2, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[-5,2,2,4]"));
        assertTrue(str.contains("[-1,0,2,2]"));

        result = solution.fourSum(new int[]{0,-7,-2,8,-7,8,3,-8,7,5,-7,3,6,-8,8,-2,4}, 19);
        assertEquals(8, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[-2,5,8,8]"));
        assertTrue(str.contains("[-2,6,7,8]"));
        assertTrue(str.contains("[0,3,8,8]"));
        assertTrue(str.contains("[0,4,7,8]"));
        assertTrue(str.contains("[0,5,6,8]"));
        assertTrue(str.contains("[3,3,5,8]"));
        assertTrue(str.contains("[3,3,6,7]"));
        assertTrue(str.contains("[3,4,5,7]"));

    }

    private void duplicateTest(Solution solution){

        List<List<Integer>> result = solution.fourSum(new int[]{1,1,1,2,2,2}, 6);
        assertEquals(1, result.size());
    }
}
