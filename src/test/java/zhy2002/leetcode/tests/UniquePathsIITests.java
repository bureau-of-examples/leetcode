package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.uniquepathii.Solution;
import static org.junit.Assert.*;

public class UniquePathsIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(0, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("")));
        assertEquals(1, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0")));
        assertEquals(0, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("1")));
        assertEquals(0, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0 0 0 1 0")));
        assertEquals(1, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0 0,1 0")));
        assertEquals(2, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0 0,0 0")));
        assertEquals(6, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0 0 0,0 0 0,0 0 0")));
        assertEquals(2, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0 0 0,0 1 0,0 0 0")));
        assertEquals(7, solution.uniquePathsWithObstacles(Utils.stringToIntMatrix("0 0 0 0,0 1 0 0,0 0 0 0,0 0 1 0,0 0 0 0")));

    }
}
