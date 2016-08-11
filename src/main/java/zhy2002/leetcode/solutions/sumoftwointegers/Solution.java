package zhy2002.leetcode.solutions.sumoftwointegers;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class Solution {

    public int getSum(int a, int b) {
        if(a == 0)
            return b;
        if(b == 0)
            return a;

        int withoutCarry = a ^ b;
        int carry = (a & b) << 1;
        return getSum(withoutCarry, carry);
    }
}
