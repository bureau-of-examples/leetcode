package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.painthouse.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PaintHouseTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        int result = solution.minCost(new int[][]{});
        assertThat(result, equalTo(0));

        result = solution.minCost(new int[][]{{3, 5, 1}});
        assertThat(result, equalTo(1));

        result = solution.minCost(new int[][]{{2,1,4}, {3, 5, 1}});
        assertThat(result, equalTo(2));

        result = solution.minCost(new int[][]{{100,4,4},{2,1,4}, {3, 5, 1}});
        assertThat(result, equalTo(6));
    }
}
