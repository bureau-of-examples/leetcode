package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.graphvalidtree.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GraphValidTreeTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        boolean result = solution.validTree(5, new int[][]{{0,1}, {0,2}, {0,3}, {1,4}});
        assertThat(result, equalTo(true));

        result = solution.validTree(5, new int[][]{{0,1}, {1,2}, {2,3}, {1,3}, {1,4}});
        assertThat(result, equalTo(false));

        result = solution.validTree(5, new int[][]{{0,1}, {1,2}, {2,3}, {3,4}, {4,0}});
        assertThat(result, equalTo(false));

        result = solution.validTree(5, new int[][]{{0,1},{0,4},{1,4},{2,3}});
        assertThat(result, equalTo(false));

    }
}
