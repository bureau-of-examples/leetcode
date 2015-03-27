package zhy2002.leetcode.solutions.reverseinteger;

/**
 * Get each digit (from the least significant) and then append to the result.
 * Use long to avoid/detect overflow.
 */
public class LongSolution implements Solution {

    @Override
    public int reverse(int x) {
        boolean sign = x >= 0;
        long num = x;//use long to avoid overflow
        if (!sign)
            num = -num;
        long result = 0;

        while (num != 0) {
            int digit = (int) (num % 10);
            num = num / 10;

            result = result * 10 + digit;
            if (result > 0x7FFFFFFFL)
                return 0;
        }
        return (int) (sign ? result : -result);
    }
}


