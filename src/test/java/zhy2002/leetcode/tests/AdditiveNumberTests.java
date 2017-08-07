package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/additive-number/description/
 */
public class AdditiveNumberTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.isAdditiveNumber("1023"), equalTo(false));
        assertThat(solution.isAdditiveNumber("101"), equalTo(true));
        assertThat(solution.isAdditiveNumber("1991070199"), equalTo(false));
        assertThat(solution.isAdditiveNumber("199100199"), equalTo(true));
        assertThat(solution.isAdditiveNumber("112358"), equalTo(true));
    }

    public class Solution {
        public boolean isAdditiveNumber(String num) {
            int maxLen1 = (num.length() - 1) / 2;
            for (int end1 = 1; end1 <= maxLen1; end1++) {
                if (num.charAt(0) == '0' && end1 != 1)
                    continue;
                int maxLen2 = num.length() - end1 * 2;
                for (int end2 = end1 + 1; end2 <= end1 + maxLen2; end2++) {
                    if (num.charAt(end1) == '0' && end2 != end1 + 1)
                        continue;
                    long num1 = Long.parseLong(num.substring(0, end1));
                    long num2 = Long.parseLong(num.substring(end1, end2));
                    if (isValid(num, num1, num2, end2))
                        return true;
                }
            }
            return false;
        }

        private boolean isValid(String num, long num1, long num2, int index) {
            long num3 = num1 + num2;
            String str3 = String.valueOf(num3);
            int end3 = index + str3.length();
            if (end3 <= num.length() &&
                    str3.equals(num.substring(index, end3)) &&
                    (end3 == num.length() || isValid(num, num2, num3, end3)))
                return true;

            return false;
        }
    }
}
