package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.mergeintervals.Solution;
import static org.junit.Assert.*;

public class MergeIntervalsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("[[-2,-1],[1,3],[4,9]]", Utils.intervalsToString(solution.merge(Utils.stringToIntervals("[[1,2], [5,9], [2,3], [-2,-1], [4,6]]"))));
        assertEquals("[[3,5],[9,10]]", Utils.intervalsToString(solution.merge(Utils.stringToIntervals("[[3,5],[9,10]]"))));
        assertEquals("[[3,12]]", Utils.intervalsToString(solution.merge(Utils.stringToIntervals("[[3,5],[5,12],[9,10]]"))));
        assertEquals("[[0,1],[2,19]]", Utils.intervalsToString(solution.merge(Utils.stringToIntervals("[[3,5],[2,12],[0,1],[6,19]]"))));

    }
}
