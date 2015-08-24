package zhy2002.leetcode.solutions.adddigits;

/**
 * https://leetcode.com/problems/add-digits/
 * See https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
 */
public class Solution {

    public int addDigits(int num) {
        if (num == 0)
            return 0;

        int result = num % 9;
        return result == 0 ? 9 : result;
    }

}
