package zhy2002.leetcode.tests;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.subsetii.Solution;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsetsWithDup(new int[]{});
        assertEquals("[[]]", Utils.listOfListToString(result));

        result = solution.subsetsWithDup(new int[]{1});
        assertEquals("[[],[1]]", Utils.listOfListToString(result));

        result = solution.subsetsWithDup(new int[]{1,2});
        assertEquals("[[],[1],[2],[1,2]]", Utils.listOfListToString(result));

        result = solution.subsetsWithDup(new int[]{1,2,2});
        assertEquals("[[],[1],[2],[1,2],[2,2],[1,2,2]]", Utils.listOfListToString(result));

        result = solution.subsetsWithDup(new int[]{3,2,1,1,1});
        assertEquals("[[],[1],[1,1],[1,1,1],[2],[1,2],[1,1,2],[1,1,1,2],[3],[1,3],[1,1,3],[1,1,1,3],[2,3],[1,2,3],[1,1,2,3],[1,1,1,2,3]]", Utils.listOfListToString(result));

    }
}
