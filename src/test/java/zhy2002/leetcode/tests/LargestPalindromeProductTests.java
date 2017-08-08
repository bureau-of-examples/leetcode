package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/largest-palindrome-product/description/
 */
public class LargestPalindromeProductTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.largestPalindrome(5), equalTo(677));
    }

    public class Solution {
        public int largestPalindrome(int n) {
            if (n == 1)
                return 9;
            int max = (int) Math.pow(10, n) - 1;
            int min = (int) Math.pow(10, n - 1);
            for (int i = max; i >= min; i--) {
                long p = Long.parseLong(i + new StringBuilder().append(i).reverse().toString());
                for (long j = max; j * j >= p; j--) {
                    if (p % j == 0)
                        return (int) (p % 1337);
                }
            }
            return -1;
        }

        public int largestPalindrome2(int n) {
            if (n == 1) return 9;
            int max = (int) Math.pow(10, n) - 1;
            for (int v = max - 1; v > max / 10; v--) {
                long u = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
                for (long x = max; x * x >= u; x--)
                    if (u % x == 0)
                        return (int) (u % 1337);
            }
            return 0;
        }
    }

}
