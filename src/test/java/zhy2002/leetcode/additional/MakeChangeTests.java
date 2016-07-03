package zhy2002.leetcode.additional;

import org.junit.Test;
import zhy2002.leetcode.additional.makechange.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MakeChangeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.calcWays(0), equalTo(1));
        assertThat(solution.calcWays(1), equalTo(1));
        assertThat(solution.calcWays(4), equalTo(1));
        assertThat(solution.calcWays(5), equalTo(2));
        assertThat(solution.calcWays(10), equalTo(4));
        assertThat(solution.calcWays(14), equalTo(4));
        assertThat(solution.calcWays(15), equalTo(6));
        assertThat(solution.calcWays(25), equalTo(13));
    }
}
