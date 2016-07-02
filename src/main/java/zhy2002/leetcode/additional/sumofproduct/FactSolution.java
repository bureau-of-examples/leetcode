package zhy2002.leetcode.additional.sumofproduct;

import java.math.BigInteger;

/**
 * Utilize this fact:
 * The product of n consecutive integers is divisible by n factorial.
 */
public class FactSolution implements Solution {

    @Override
    public BigInteger calculate(int n, int c) {
        BigInteger sum1 = BigInteger.ZERO;
        BigInteger product = BigInteger.ONE;
        for (int end = 2; end <= n && end <= c + 1; end++) {
            int inValue = end - 1;
            product = product.multiply(BigInteger.valueOf(inValue));
            sum1 = sum1.add(product);
        }

        BigInteger sum2 = BigInteger.ZERO;
        product = BigInteger.ONE;
        int outValue = 1;
        for (int end = c + 2; end <= n; end++) {
            int inValue = end - 1;
            if (inValue % outValue == 0) {
                product = product.multiply(BigInteger.valueOf(inValue / outValue));
            } else {
                product = product.multiply(BigInteger.valueOf(inValue));
                product = product.divide(BigInteger.valueOf(outValue));
            }
            outValue++;
            sum2 = sum2.add(product);
        }
        BigInteger factC = fact(c);
        return sum1.add(factC.multiply(sum2));
    }

    private BigInteger fact(int c) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= c; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
