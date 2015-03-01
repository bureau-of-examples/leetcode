package zhy2002.leetcode.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import zhy2002.leetcode.solutions.permutations.Solution;
import zhy2002.leetcode.Utils;

public class PermutationsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        List<List<Integer>> result = solution.permute(new int[]{});
        assertEquals("[]", Utils.listOfListToString(result));

        result = solution.permute(new int[]{4});
        assertEquals("[[4]]", Utils.listOfListToString(result));

        result = solution.permute(new int[]{1, 3});
        assertEquals("[[1,3],[3,1]]", Utils.listOfListToString(result));

        result = solution.permute(new int[]{1, 2, 3});
        assertEquals("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", Utils.listOfListToString(result));


    }
}
