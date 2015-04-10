package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.subsets.Solution;
import static org.junit.Assert.*;

public class SubsetsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("[[],[1]]", Utils.listOfListToString(solution.subsets(new int[]{1})));
        assertEquals("[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]", Utils.listOfListToString(solution.subsets(new int[]{3, 1, 2})));
        assertEquals("[[],[1],[2],[3],[4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4],[1,2,3],[1,2,4],[1,3,4],[2,3,4],[1,2,3,4]]", Utils.listOfListToString(solution.subsets(new int[]{3, 4, 1, 2})));
    }
}
