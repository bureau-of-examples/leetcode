package zhy2002.leetcode.solutions.dividetwointegers;


public class QuickSolution implements Solution {
    @Override
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

        //find k so that 2^k * b <= INT_MAX && 2^(K+1) * b > INT_MAX
        //k = number of 0 bits after sign bit
        int k, b;
        if(divisor > 65535 || divisor < -65535){
            b = (divisor < 0 ? -divisor : divisor) << 1;
            k = 0;
        } else {
            b = (divisor < 0 ? -divisor : divisor) << 16;
            k = 15;
        }

        while (b > 0){
            k++;
            b <<= 1;
        }

        //reduce dividend to this range
        boolean sameSign = dividend > 0 == divisor > 0;
        int lower, upper;
        if(dividend > 0){
            lower = 0;
            upper = sameSign ? divisor : -divisor;
        } else {
            lower = sameSign ? divisor : -divisor;
            upper = 0;
        }

        //try to reduce 2^p * b at a time
        int count = 0;
        int start = 0, end = k;
        boolean dividendPositive = dividend > 0;
        int signBit = divisor & 0x80000000;
        while (true){
            if(dividendPositive){
                if(dividend >= lower && dividend < upper)
                    break;
            } else {
                if(dividend > lower && dividend <= upper)
                    break;
            }

            int component = signBit | (divisor << end);
            if(sameSign ? (dividendPositive ? dividend >= component : dividend <= component) : (dividendPositive ? dividend >= -component : dividend <= -component)){
                dividend -= sameSign ? component : -component;
                //int multiplier = 1 << end;
                count += 1 << end; //multiplier;
            } else {
                end = (start + end) >>> 1;
            }
        }

        return sameSign ? count : -count;
    }
}
