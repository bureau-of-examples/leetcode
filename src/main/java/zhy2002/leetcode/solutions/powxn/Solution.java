package zhy2002.leetcode.solutions.powxn;

/**
 * https://leetcode.com/problems/powx-n/
 * Decompose n as a binary string b1 b2 b3 ...
 * Then calculate a^(b1 + b2 + b3 +...)
 */
public class Solution {

    public double pow(double x, int n) {

        if (n == 0)
            return 1;

        boolean positive = true;
        if (n < 0) {
            positive = false;
            n = -n;
        }

        double[] powers = new double[31];
        double result = 1;
        powers[0] = x;
        int i = 0;
        while (true) {

            int bit = n & 1;
            n >>>= 1;
            if (bit == 1) {
                result *= powers[i];
            }
            if (n == 0 || i == 30)
                break;
            i++;
            powers[i] = powers[i - 1] * powers[i - 1];
        }
        return positive ? result : 1.0 / (n != 0 ? powers[30] * powers[30] : result);
    }
}
