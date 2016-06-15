package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.paintfence.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PaintFenceTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        int result = solution.numWays(0, 0);
        assertThat(result, equalTo(0));

        result = solution.numWays(1, 10);
        assertThat(result, equalTo(10));

        result = solution.numWays(2, 10);
        assertThat(result, equalTo(100));

        result = solution.numWays(3, 10);
        assertThat(result, equalTo(990));

        result = solution.numWays(4, 10);
        assertThat(result, equalTo(9810));

        result = solution.numWays(4, 9);
        assertThat(result, equalTo(6408));
    }
}
