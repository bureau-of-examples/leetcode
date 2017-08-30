package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.coinchange.Solution;

import java.util.Arrays;

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

    @Test
    public void solution2Test() {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.lengthOfLIS(new int[] {10,9,2,5,3,4}));
    }

    class Solution2 {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0)
                return 0;

            int[] minEndElements = new int[nums.length];
            minEndElements[0] = nums[0];
            int size = 1;

            for (int i=1; i<nums.length; i++) {
                if (nums[i] > minEndElements[size - 1]) {
                    minEndElements[size++] = nums[i];
                } else {
                    int pos = Arrays.binarySearch(minEndElements, 0, size, nums[i]);
                    if (pos < 0) {
                        minEndElements[-pos - 1] = nums[i];
                    }
                }
            }
            return size;

        }
    }

}
