package zhy2002.leetcode.solutions.numberofdigitone;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 */
public class Solution {

    public int countDigitOne(int n) {

        if(n <= 0)
            return 0;

        int count = 0;
        int pow = 1;
        int m = n;
        while(m != 0){ //sum up number of 1s at each position, from the least significant digit
            int q = m / 10; //there is a 1 every 10 numbers
            count += q * pow; //total number of ones at the position if the current digit is 0
            int r = m % 10; //current digit
            if(r == 1){
                count += n % pow + 1; //[0,n % pow]
            } else if(r > 1){
                count += pow; //say if the current digit is 2, then all of 1xxxx
            }
            m = q;
            pow *= 10;
        }

        return count;
    }
}
