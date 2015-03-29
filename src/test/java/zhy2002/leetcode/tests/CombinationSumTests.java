package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.combinationsum.Solution;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        List<List<Integer>> result = solution.combinationSum(new int[]{}, 0);
        assertEquals("[[]]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{3, 1}, 5);
        assertEquals("[[1,1,1,1,1],[1,1,3]]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{8, 9}, 5);
        assertEquals("[]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{8, 9}, 0);
        assertEquals("[[]]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{8, 9}, 15);
        assertEquals("[]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{8, 9}, 19);
        assertEquals("[]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{8, 9, 15}, 21);
        assertEquals("[]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{4,8,7,3}, 10);
        assertEquals("[[3,3,4],[3,7]]", Utils.listOfListToString(result));

        result = solution.combinationSum(new int[]{9,6,8,11,5,4}, 34);
        assertEquals("[[4,4,4,4,4,4,4,6],[4,4,4,4,4,4,5,5],[4,4,4,4,4,5,9],[4,4,4,4,4,6,8],[4,4,4,4,5,5,8],[4,4,4,4,6,6,6],[4,4,4,4,9,9],[4,4,4,5,5,6,6],[4,4,4,5,6,11],[4,4,4,5,8,9],[4,4,4,6,8,8],[4,4,4,11,11],[4,4,5,5,5,5,6],[4,4,5,5,5,11],[4,4,5,5,8,8],[4,4,5,6,6,9],[4,4,6,6,6,8],[4,4,6,9,11],[4,4,8,9,9],[4,5,5,5,5,5,5],[4,5,5,5,6,9],[4,5,5,6,6,8],[4,5,5,9,11],[4,5,6,8,11],[4,5,8,8,9],[4,6,6,6,6,6],[4,6,6,9,9],[4,6,8,8,8],[4,8,11,11],[5,5,5,5,5,9],[5,5,5,5,6,8],[5,5,5,8,11],[5,5,6,6,6,6],[5,5,6,9,9],[5,5,8,8,8],[5,6,6,6,11],[5,6,6,8,9],[5,9,9,11],[6,6,6,8,8],[6,6,11,11],[6,8,9,11],[8,8,9,9]]", Utils.listOfListToString(result));

    }
}
