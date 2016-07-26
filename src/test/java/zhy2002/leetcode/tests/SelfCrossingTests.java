package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.selfcrossing.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SelfCrossingTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.isSelfCrossing(new int[]{2, 1, 1, 2}), equalTo(true));
        assertThat(solution.isSelfCrossing(new int[]{1, 2, 3, 4}), equalTo(false));
        assertThat(solution.isSelfCrossing(new int[]{1, 1, 1, 1}), equalTo(true));
        assertThat(solution.isSelfCrossing(new int[]{3, 2, 6, 2, 3}), equalTo(true));
        assertThat(solution.isSelfCrossing(new int[]{3, 2, 6, 2, 2}), equalTo(false));
        assertThat(solution.isSelfCrossing(new int[]{10, 20, 30, 40, 10, 39, 5, 20}), equalTo(false));
        assertThat(solution.isSelfCrossing(new int[]{10, 20, 30, 40, 10, 39, 5, 20, 15}), equalTo(true));
        assertThat(solution.isSelfCrossing(new int[]{10, 20, 30, 40, 25, 30}), equalTo(true));
        assertThat(solution.isSelfCrossing(new int[]{10, 20, 30, 40, 25, 10}), equalTo(false));
        assertThat(solution.isSelfCrossing(new int[]{10, 20, 30, 40, 25, 10, 20, 5, 2, 1}), equalTo(false));
        assertThat(solution.isSelfCrossing(new int[]{12, 15, 7, 4, 6, 1}), equalTo(false));

    }

}
