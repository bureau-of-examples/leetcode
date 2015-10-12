package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.maximumgap.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MaximumGapTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.maximumGap(new int[]{}), equalTo(0));
        assertThat(solution.maximumGap(new int[]{111}),equalTo(0));
        assertThat(solution.maximumGap(new int[]{8, 2, -3}),equalTo(6));
        assertThat(solution.maximumGap(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1}),equalTo(Integer.MAX_VALUE));
        assertThat(solution.maximumGap(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE + 7, Integer.MIN_VALUE + 2, Integer.MIN_VALUE + 3, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 6, Integer.MIN_VALUE + 5}),equalTo(2));
        assertThat(solution.maximumGap(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2, Integer.MIN_VALUE + 3, Integer.MIN_VALUE + 4, Integer.MIN_VALUE + 5, Integer.MIN_VALUE + 6, Integer.MIN_VALUE + 7}),equalTo(1));
        assertThat(solution.maximumGap(new int[]{3, 1, 2}),equalTo(1));
        assertThat(solution.maximumGap(new int[]{9, 9, 9, 9}),equalTo(0));
        assertThat(1, equalTo(1));

    }
}
