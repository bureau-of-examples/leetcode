package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import zhy2002.leetcode.solutions.twosumii.Solution;

public class TwoSumIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.twoSum(new int[]{1}, 4), nullValue());
        assertThat(solution.twoSum(new int[]{4}, 4), nullValue());
        assertThat(solution.twoSum(new int[]{1, 2, 3, 5}, 4), equalTo(new int[]{1, 3}));
        assertThat(solution.twoSum(new int[]{1, 2, 2, 4, 5}, 4), equalTo(new int[]{2, 3}));
        assertThat(solution.twoSum(new int[]{1, 1, 2, 2, 4, 5, 6, 7}, 2), equalTo(new int[]{1, 2}));
        assertThat(solution.twoSum(new int[]{1, 1, 2, 2, 4, 5, 6, 7}, 13), equalTo(new int[]{7, 8}));
        assertThat(solution.twoSum(new int[]{1, 1, 2, 2, 4, 5, 6, 7}, 12), equalTo(new int[]{6, 8}));

    }
}
