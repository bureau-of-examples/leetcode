package zhy2002.leetcode.solutions.plusone;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits == null)
            return null;

        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (!carry)
                break;
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
                carry = true;
            } else {
                carry = false;
            }
        }

        if (carry) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        } else
            return digits;

    }
}
