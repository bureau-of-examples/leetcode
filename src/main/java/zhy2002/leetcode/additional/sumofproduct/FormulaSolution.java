package zhy2002.leetcode.additional.sumofproduct;

import java.math.BigInteger;

/**
 * Solve with this theorem:
 * https://proofwiki.org/wiki/Rising_Sum_of_Binomial_Coefficients
 */
public class FormulaSolution implements Solution {
    @Override
    public BigInteger calculate(int n, int c) {
        BigInteger sum1 = BigInteger.ZERO;
        //calculate up to p(c)
        BigInteger product = BigInteger.ONE;
        for (int end = 2; end <= n && end <= c; end++) {
            int inValue = end - 1;
            product = product.multiply(BigInteger.valueOf(inValue));
            sum1 = sum1.add(product);
        }

        BigInteger sum2 = BigInteger.ZERO;
        if (n > c) { //calculate p(c+1) to p(n)
            BigInteger factC = fact(c);
            BigInteger factCPlus1 = factC.multiply(BigInteger.valueOf(c + 1));
            sum2 = factC.multiply(fact(n).divide(factCPlus1.multiply(fact(n - c - 1))));
        }
        return sum1.add(sum2);
    }

    private BigInteger fact(int c) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= c; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
