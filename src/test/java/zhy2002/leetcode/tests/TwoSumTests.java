package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.twosum.HashMapSolution;
import zhy2002.leetcode.solutions.twosum.ReferenceSolution;
import zhy2002.leetcode.solutions.twosum.Solution;
import static org.junit.Assert.*;


public class TwoSumTests {

    @Test
    public void hashMapBasicTest(){
        basicTest( new HashMapSolution());
    }

    @Test
    public void hashMapNoSolutionTest(){
        noSolutionTest(new HashMapSolution());
    }

    @Test
    public void referenceBasicTest(){
        basicTest(new ReferenceSolution());
    }

    private void basicTest(Solution solution){

        int[] result = solution.twoSum(new int[]{3, 12}, 15);
        assertArrayEquals(new int[]{1, 2}, result);

        result = solution.twoSum(new int[]{0, 4, 3, 0}, 0);
        assertArrayEquals(new int[]{1,4}, result);

        result = solution.twoSum(new int[]{1,3,5,2,4}, 8);
        assertArrayEquals(new int[]{2, 3}, result);

        result = solution.twoSum(new int[]{3, 2, 5, 2, 0}, 4);
        assertArrayEquals(new int[]{2, 4}, result);

        result = solution.twoSum(new int[]{3, 7, 2, 6, 3, 11, 12, 1}, 3);
        assertArrayEquals(new int[]{3, 8}, result);
    }

    private void noSolutionTest(Solution solution){
        int[] result = solution.twoSum(new int[]{}, 0);
        assertArrayEquals(null, result);

        result = solution.twoSum(new int[]{3}, 3);
        assertArrayEquals(null, result);

        result = solution.twoSum(new int[]{3, 12}, 3);
        assertArrayEquals(null, result);
    }
}
