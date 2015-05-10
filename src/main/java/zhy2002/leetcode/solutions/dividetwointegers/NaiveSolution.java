package zhy2002.leetcode.solutions.dividetwointegers;

/**
 * Naive solution by subtraction.
 */
public class NaiveSolution implements Solution {

    public int divide(int dividend, int divisor) {

        //edge cases
        if(divisor == 0)
            throw new IllegalArgumentException("divisor");
        if(dividend == 0)
            return 0;
        if(divisor == Integer.MIN_VALUE)
            return dividend == Integer.MIN_VALUE ? 1 : 0;

        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;


        boolean sameSign = dividend > 0 == divisor > 0;
        int lower, upper;//range of remainder
        if(dividend > 0){
            lower = 0;
            upper = sameSign ? divisor : -divisor;
        } else {
            lower = sameSign ? divisor : -divisor;
            upper = 0;
        }

        //see how many subtractions are needed to reduce dividend into the remainder range.
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
