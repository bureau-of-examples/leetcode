package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.strobogrammaticnumberiii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class StrobogrammaticNumberIIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        int count = solution.strobogrammaticInRange("1", "9");
        assertThat(count, equalTo(2));

        count = solution.strobogrammaticInRange("0", "9");
        assertThat(count, equalTo(3));

        count = solution.strobogrammaticInRange("10", "100");
        assertThat(count, equalTo(4));

        count = solution.strobogrammaticInRange("1", "100");
        assertThat(count, equalTo(6));

        count = solution.strobogrammaticInRange("2", "100");
        assertThat(count, equalTo(5));

        count = solution.strobogrammaticInRange("2", "95");
        assertThat(count, equalTo(4));

        count = solution.strobogrammaticInRange("50", "100");
        assertThat(count, equalTo(3));

        count = solution.strobogrammaticInRange("50", "101");
        assertThat(count, equalTo(4));

        count = solution.strobogrammaticInRange("50", "112");
        assertThat(count, equalTo(5));

        count = solution.strobogrammaticInRange("0", "0");
        assertThat(count, equalTo(1));

        count = solution.strobogrammaticInRange("100", "50");
        assertThat(count, equalTo(0));

    }
}
