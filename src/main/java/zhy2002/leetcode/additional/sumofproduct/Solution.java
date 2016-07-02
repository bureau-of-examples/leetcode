package zhy2002.leetcode.additional.sumofproduct;

import java.math.BigInteger;

/**
 * Concrete solutions will implement this interface.
 */
public interface Solution {

    /**
     * Return the p(1) + p(2) + p(3) + ... + p(n) where:
     * p(i) is the product of positive numbers in range [i-c, i-1].
     * Specially p(1) = 0.
     * @param n a positive number.
     * @param c a positive number.
     * @return see description.
     */
    BigInteger calculate(int n, int c);
}
