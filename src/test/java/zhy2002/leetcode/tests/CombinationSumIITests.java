package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.combinationsumii.RecursiveSolution;
import zhy2002.leetcode.solutions.combinationsumii.ReferenceSolution;
import zhy2002.leetcode.solutions.combinationsumii.ShortSolution;
import zhy2002.leetcode.solutions.combinationsumii.Solution;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumIITests {

    @Test
    public void recursiveBasicTest() {
        basicTest(new RecursiveSolution());
    }


    @Test
    public void zeroTest() {//if works with 0

        Solution solution = new RecursiveSolution();
        assertEquals("[]", Utils.listOfListToString(solution.combinationSum2(new int[]{}, 0)));
        assertEquals("[[0],[0,0],[0,0,0]]", Utils.listOfListToString(solution.combinationSum2(new int[]{0, 0, 0, 1}, 0)));
        assertEquals("[[1,1],[0,1,1]]", Utils.listOfListToString(solution.combinationSum2(new int[]{1, 0, 1}, 2)));
        assertEquals("[[1,1],[0,1,1],[0,0,1,1]]", Utils.listOfListToString(solution.combinationSum2(new int[]{1, 0, 0, 1}, 2)));
        assertEquals("[[2],[1,1],[0,2],[0,1,1],[0,0,2],[0,0,1,1]]", Utils.listOfListToString(solution.combinationSum2(new int[]{0, 0, 1, 1, 2}, 2)));
    }

    @Test
    public void negativeTest() {//if works with negative
        Solution solution = new RecursiveSolution();
        assertEquals("[[2],[1,1],[-1,1,2]]", Utils.listOfListToString(solution.combinationSum2(new int[]{1, 1, 2, -1}, 2)));
        assertEquals("[[-2,2]]", Utils.listOfListToString(solution.combinationSum2(new int[]{2, -2}, 0)));
        assertEquals("[[1],[0,1],[-3,1,1,2],[-3,0,1,1,2]]", Utils.listOfListToString(solution.combinationSum2(new int[]{2, -3, 0, 1, 1, 5}, 1)));
        assertEquals("[[1,2],[-1,1,1,2]]", Utils.listOfListToString(solution.combinationSum2(new int[]{1, 1, 2, -1}, 3)));
    }

    @Test
    public void shortBasicTest() {
        basicTest(new ShortSolution());
    }

    @Test
    public void referenceBasicTest() {
        basicTest(new ReferenceSolution());
    }

    private void basicTest(Solution solution) {

        assertEquals("[]", Utils.listOfListToString(solution.combinationSum2(new int[]{}, 5)));
        assertEquals("[[1,1]]", Utils.listOfListToString(solution.combinationSum2(new int[]{1, 1, 1}, 2)));
        List<List<Integer>> result = solution.combinationSum2(new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27);
        Integer[][] expected = {{27}, {13, 14}, {11, 16}, {10, 17}, {9, 18}, {9, 9, 9}, {8, 9, 10}, {8, 8, 11}, {7, 20}, {7, 9, 11}, {7, 8, 12}, {6, 21}, {6, 10, 11}, {6, 9, 12}, {6, 8, 13}, {6, 7, 14}, {6, 6, 7, 8}};
        List<List<Integer>> expected2 = Utils.arrayOfArrayToListOfList(expected);
        assertEquals(result.size(), expected2.size());
        List<String> resultAsString = new ArrayList<>();
        for (List<Integer> item : result) {
            resultAsString.add(Utils.integersToString(item));
        }

        for (List<Integer> item : expected2) {
            assertTrue(resultAsString.contains(Utils.integersToString(item)));
        }


    }
}
