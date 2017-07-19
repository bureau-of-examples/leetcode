package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/third-maximum-number/#/description
 */
public class ThirdMaximumNumber2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.thirdMax(new int[]{3, 2, 2, 1}), equalTo(1));
    }

    public class Solution {
        public int thirdMax(int[] nums) {
            int[] top = new int[3];
            int topLen = 0;

            outer:
            for (int num : nums) {
                int insPos = 0;
                for (; insPos < topLen; insPos++) {
                    if (top[insPos] == num)
                        continue outer;
                    if (top[insPos] < num)
                        break;
                }
                if (insPos < top.length) {
                    for (int i = top.length - 1; i > insPos; i--) {
                        top[i] = top[i - 1];
                    }
                    top[insPos] = num;
                    if (topLen < top.length) {
                        topLen++;
                    }
                }

            }
            return topLen < top.length ? top[0] : top[topLen - 1];
        }
    }
}
