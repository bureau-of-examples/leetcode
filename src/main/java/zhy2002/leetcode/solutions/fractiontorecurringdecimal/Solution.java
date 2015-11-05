package zhy2002.leetcode.solutions.fractiontorecurringdecimal;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class Solution {

    //todo do this again without using Long.
    //Model manual division procedure.
    public String fractionToDecimal(int numerator, int denominator) {

        if (denominator == 0)
            throw new IllegalArgumentException("denominator");

        if (numerator == 0)
            return "0";

        //d and n are not 0
        long n = numerator, d = denominator; //avoid overflow
        String sign = n > 0 == d > 0 ? "" : "-";
        if (n < 0)
            n = -n;
        if (d < 0)
            d = -d;

        StringBuilder result = new StringBuilder(String.valueOf(n / d));//integer part
        long remainder = (n % d) * 10;
        if (remainder != 0) {
            result.append(".");
            HashMap<Long, Integer> remainderIndex = new HashMap<>();
            do { //textbook division procedure
                result.append(remainder / d);
                remainderIndex.put(remainder, result.length() - 1);
                remainder = remainder % d;
                remainder *= 10;
                if (remainderIndex.containsKey(remainder)) {
                    int index = remainderIndex.get(remainder);
                    return sign + result.substring(0, index) + "(" + result.substring(index) + ")";
                }
            } while (remainder != 0);
        }
        return sign + result.toString();
    }
}
