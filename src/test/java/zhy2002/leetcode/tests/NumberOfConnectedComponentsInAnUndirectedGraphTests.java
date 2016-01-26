package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.numberofconnectedcomponentsinanundirectedgraph.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberOfConnectedComponentsInAnUndirectedGraphTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertThat(solution.countComponents(1, new int[][]{}), equalTo(1));
        assertThat(solution.countComponents(5, new int[][]{}), equalTo(5));
        assertThat(solution.countComponents(5, new int[][]{{0,1}}), equalTo(4));
        assertThat(solution.countComponents(5, new int[][]{{0,1}, {3,4}}), equalTo(3));
        assertThat(solution.countComponents(5, new int[][]{{0,1}, {2,3}, {3,4}}), equalTo(2));
        assertThat(solution.countComponents(5, new int[][]{{0,1}, {2,3}, {3,4}, {0, 4}}), equalTo(1));
    }
}
