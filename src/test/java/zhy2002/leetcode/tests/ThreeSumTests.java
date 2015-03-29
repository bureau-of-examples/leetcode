package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.threesum.Solution;
import zhy2002.leetcode.solutions.threesum.TwoPointerSolution;

import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTests {

    @Test
    public void twoPointersBasicTest() {
        basicTest(new TwoPointerSolution());
    }

    private void basicTest(Solution solution) {
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result.size());
        String str = Utils.listOfListToString(result);
        assertTrue(str.contains("[-1,-1,2]"));
        assertTrue(str.contains("[-1,0,1]"));

        result = solution.threeSum(new int[]{1, 1, 1, -2});
        assertEquals(1, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[-2,1,1]"));

        result = solution.threeSum(new int[]{1, -3, 2, 1, 1, -2});
        assertEquals(2, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[-3,1,2]"));
        assertTrue(str.contains("[-2,1,1]"));

        result = solution.threeSum(new int[]{0, 0, 0, 0});
        assertEquals(1, result.size());
        str = Utils.listOfListToString(result);
        assertTrue(str.contains("[0,0,0]"));

    }
}
