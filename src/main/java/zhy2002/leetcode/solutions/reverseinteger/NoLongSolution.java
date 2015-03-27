package zhy2002.leetcode.solutions.reverseinteger;

/**
 * https://leetcode.com/discuss/27422/java-solution-without-long
 * Brilliant solution from the internet folks.
 */
public class NoLongSolution implements Solution {

    public int reverse(int x) {
        // edge case
        if(x==Integer.MIN_VALUE) return 0;

        // negative number, convert from positive
        if(x < 0) return -reverse(-x);

        int result = 0;
        while(x != 0){

            // edge case, overflow
            if(result > Integer.MAX_VALUE/10) return 0;//MAX_VALUE/10=214748364 is ok but 214748365 is not as MAX_VALUE is 2147483647
            //so we can add 0 - 7 without overflow while 8 and 9 are impossible (out of range of int)
            result *= 10;
            result += x%10;
            x /= 10;
        }
        return result;
    }
}
