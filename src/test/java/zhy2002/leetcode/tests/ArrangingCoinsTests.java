package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/arranging-coins/#/description
 */
public class ArrangingCoinsTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int arrangeCoins(int n) {
            return (int) ((Math.sqrt(8.0 * n + 1) - 1) / 2);
        }
    }

}
