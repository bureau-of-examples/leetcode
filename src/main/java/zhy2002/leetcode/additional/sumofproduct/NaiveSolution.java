package zhy2002.leetcode.additional.sumofproduct;

import java.math.BigInteger;

/**
 * Maintain a window of production.
 */
public class NaiveSolution implements Solution {

    public BigInteger calculate(int n, int c) {
        int start, end;
        BigInteger sum = BigInteger.ZERO;
        BigInteger product = BigInteger.ONE;
        for (start = 1 - c, end = 1; end <= n; start++, end++) { //active range is [start, end)
            int inValue = end - 1;
            int outValue = start - 1;
            boolean optimize = false;
            if (inValue > 0) {
                if (outValue > 0) {
                    if (inValue % outValue != 0) {
                        product = product.divide(BigInteger.valueOf(outValue));
                    } else {
                        optimize = true;
                    }
                }
                if (optimize) {
                    product = product.multiply(BigInteger.valueOf(inValue / outValue));
                } else {
                    product = product.multiply(BigInteger.valueOf(inValue));
                }
                sum = sum.add(product);
            }
        }
        return sum;
    }
}
