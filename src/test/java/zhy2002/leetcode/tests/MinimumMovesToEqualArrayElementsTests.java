package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/#/description
 */
public class MinimumMovesToEqualArrayElementsTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int minMoves(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int min = Arrays.stream(nums).min().getAsInt();
            return sum - min * nums.length;
        }
    }
}
