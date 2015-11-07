package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.largenumber.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LargestNumberTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.largestNumber(new int[]{18, 2, 91, 0, 0}), equalTo("9121800"));
        assertThat(solution.largestNumber(new int[]{0, 0}), equalTo("0"));
        assertThat(solution.largestNumber(new int[]{12, 121}), equalTo("12121"));
        assertThat(solution.largestNumber(new int[]{213, 21}), equalTo("21321"));

    }
}
