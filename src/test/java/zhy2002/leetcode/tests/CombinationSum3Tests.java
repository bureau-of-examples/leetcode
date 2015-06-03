package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.combinationsumiii.Solution;
import static org.junit.Assert.*;

public class CombinationSum3Tests {

    @Test
    public void basicTest(){
         Solution solution = new Solution();
         assertEquals("[[1,2,4]]", Utils.listOfListToString(solution.combinationSum3(3, 7)));
         assertEquals("[[1,2,6],[1,3,5],[2,3,4]]", Utils.listOfListToString(solution.combinationSum3(3, 9)));
    }
}
