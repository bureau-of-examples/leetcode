package zhy2002.leetcode.solutions.dividetwointegers;

/**
 * Naive solution by subtraction.
 */
public class NaiveSolution implements Solution {

    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            throw new IllegalArgumentException("divisor");
        if(dividend == 0)
            return 0;
        if(divisor == Integer.MIN_VALUE)
            return 0;

        boolean sameSign = dividend > 0 == divisor > 0;
        int lower, upper;
        if(dividend > 0){
            lower = 0;
            upper = sameSign ? divisor : -divisor;
        } else {
            lower = sameSign ? divisor : -divisor;
            upper = 0;
        }

        int count = 0;
        boolean dividendPositive = dividend > 0;
        while (true){
            if(dividendPositive){
                if(dividend >= lower && dividend < upper)
                    break;
            } else {
                if(dividend > lower && dividend <= upper)
                    break;
            }

            dividend -= sameSign ? divisor : -divisor;
            count++;
        }

        return sameSign ? count : -count;
    }
}
