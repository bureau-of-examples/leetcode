package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.coinchange.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoinChangeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.coinChange(new int[]{1, 2, 5}, 11), equalTo(3));
        assertThat(solution.coinChange(new int[]{1, 2, 5}, 10), equalTo(2));
        assertThat(solution.coinChange(new int[]{1, 2, 5}, 14), equalTo(4));
        assertThat(solution.coinChange(new int[]{1, 2, 5,10}, 14), equalTo(3));
        assertThat(solution.coinChange(new int[]{1, 2, 5,10}, 2), equalTo(1));
        assertThat(solution.coinChange(new int[]{2}, 3), equalTo(-1));
        assertThat(solution.coinChange(new int[]{2,5,7,98}, 345), equalTo(11));
        assertThat(solution.coinChange(new int[]{2,5,7,98}, 111), equalTo(5));
        assertThat(solution.coinChange(new int[]{2,5,7,98}, 666), equalTo(18));
    }

}
