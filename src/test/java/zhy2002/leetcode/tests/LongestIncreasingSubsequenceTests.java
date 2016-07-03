package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestincreasingsubsequence.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LongestIncreasingSubsequenceTests {

    @Test
    public void n2BasicTest() {
        basicTest(new N2Solution());
    }

    @Test
    public void nLognBasicTest() {
        basicTest(new NLogNSolution());
    }

    @Test
    public void nLognArrayBasicTest() {
        basicTest(new NLogNArraySolution());
    }

    private void basicTest(Solution solution) {

        int result = solution.lengthOfLIS(new int[]{});
        assertThat(result, equalTo(0));

        result = solution.lengthOfLIS(new int[]{1});
        assertThat(result, equalTo(1));

        result = solution.lengthOfLIS(new int[]{1, 2, 3});
        assertThat(result, equalTo(3));

        result = solution.lengthOfLIS(new int[]{5, 1, 2, 3, 0});
        assertThat(result, equalTo(3));

        result = solution.lengthOfLIS(new int[]{5, 1, -1, 2, 6, 3, 0});
        assertThat(result, equalTo(3));

        result = solution.lengthOfLIS(new int[]{0, 9, 2, 5, 3, 7, 101, 18});
        assertThat(result, equalTo(5));

        result = solution.lengthOfLIS(new int[]{1, 1, 1});
        assertThat(result, equalTo(1));

        result = solution.lengthOfLIS(new int[]{1, 1, 1});
        assertThat(result, equalTo(1));

        result = solution.lengthOfLIS(new int[]{2, 2, 4, 1, 3, 9, 10, 4, 5, 3, 2, 1, 6, 6,1, 0, 12});
        assertThat(result, equalTo(6));

        result = solution.lengthOfLIS(new int[]{7, 6, 2, 2, 5, 4, 1, 3, 9, 10, 4, 5, 3, 2, 1, 6, 6, 7, 2, 1, -1, 0, 12, 24, 33});
        assertThat(result, equalTo(9));
    }
}
