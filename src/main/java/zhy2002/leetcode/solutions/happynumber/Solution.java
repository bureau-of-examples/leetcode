package zhy2002.leetcode.solutions.happynumber;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/
 * Use a hash set to check for dead loops: calculation results in number is already calculated.
 */
public class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> calculated = new HashSet<>();
        while (true) {
            if (n == 1)
                return true;
            calculated.add(n);
            char[] digits = String.valueOf(n).toCharArray();
            int next = 0;
            for (char digit : digits) {
                int d = digit - '0';
                next += d * d;
            }
            if (calculated.contains(next))
                return false;

            n = next;
        }
    }

}
