package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.maximumsizesubarraysumequalsk.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MaximumSizeSubarraySumEqualsKTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        assertThat(solution.maxSubArrayLen(new int[0], 10), equalTo(0));
        assertThat(solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3), equalTo(4));
        assertThat(solution.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1), equalTo(2));
        assertThat(solution.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 11), equalTo(0));
        assertThat(solution.maxSubArrayLen(new int[]{1, 2, 3, 4, 5, 6, 7}, 13), equalTo(2));
        assertThat(solution.maxSubArrayLen(new int[]{1, 2, 3, 4, 5, 6, 7}, 12), equalTo(3));
    }

}
