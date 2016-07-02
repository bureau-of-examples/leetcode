package zhy2002.leetcode.additional.sumofproduct;

import java.math.BigInteger;

/**
 * Use formula:
 * 1*2*3*...*c + 2*3*4*...*(c+1) + ... + k*(k+1)*(k+2)*(k+c-1) =
 * (k*(k+1)*(k+2)*....*(k+c))/(c+1)
 * <p>
 * See
 * - http://www.maa.org/sites/default/files/Chilaka99700241.pdf
 * - http://math.stackexchange.com/questions/600818/induction-proof-sum-of-products-of-3-consecutive-numbers
 */
public class InductionSolution implements Solution {

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
            int k = n - c;
            product = BigInteger.ONE;
            for (int i = k; i <= n; i++) {
                product = product.multiply(BigInteger.valueOf(i));
            }
            sum2 = product.divide(BigInteger.valueOf(c + 1));
        }

        return sum1.add(sum2);
    }
}
