package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.combinations.Solution;
import static org.junit.Assert.*;

public class CombinationsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("[[1],[2],[3]]", Utils.listOfListToString(solution.combine(3, 1)));
        assertEquals("[[1,2],[1,3],[2,3]]", Utils.listOfListToString(solution.combine(3, 2)));
        assertEquals("[[1,2,3]]", Utils.listOfListToString(solution.combine(3, 3)));
        assertEquals("[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]", Utils.listOfListToString(solution.combine(4,2)));
    }


}
