package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.sumoftwointegers.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SumOfTwoIntegersTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertThat(solution.getSum(1, 1), equalTo(2));
        assertThat(solution.getSum(1, 3), equalTo(4));
        assertThat(solution.getSum(-1, 1), equalTo(0));
        assertThat(solution.getSum(1, 4), equalTo(5));
        assertThat(solution.getSum(-2, 6), equalTo(4));
    }
}
