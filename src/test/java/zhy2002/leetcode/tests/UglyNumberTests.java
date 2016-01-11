package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.uglynumber.Solution;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class UglyNumberTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertThat(solution.isUgly(1), equalTo(true));
        assertThat(solution.isUgly(2), equalTo(true));
        assertThat(solution.isUgly(3), equalTo(true));
        assertThat(solution.isUgly(4), equalTo(true));
        assertThat(solution.isUgly(5), equalTo(true));
        assertThat(solution.isUgly(6), equalTo(true));
        assertThat(solution.isUgly(8), equalTo(true));
        assertThat(solution.isUgly(14), equalTo(false));
        assertThat(solution.isUgly(38), equalTo(false));
        assertThat(solution.isUgly(99), equalTo(false));

    }
}
