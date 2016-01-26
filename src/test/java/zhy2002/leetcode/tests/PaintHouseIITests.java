package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.painthouseii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PaintHouseIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        assertThat(solution.minCostII(new int[][]{}), equalTo(0));
        assertThat(solution.minCostII(new int[][]{{8}}), equalTo(8));
        assertThat(solution.minCostII(new int[][]{{3, 5, 7, 4}}), equalTo(3));
        assertThat(solution.minCostII(new int[][]{{8, 2, 7, 4}, {3, 5, 7, 4}}), equalTo(5));
        assertThat(solution.minCostII(new int[][]{{1, 4, 5, 2}, {8, 2, 7, 4}, {3, 5, 7, 4}}), equalTo(6));
        assertThat(solution.minCostII(new int[][]{{1, 12, 31, 55}, {1, 4, 5, 2}, {8, 2, 7, 4}, {3, 5, 7, 4}}), equalTo(8));

    }
}
