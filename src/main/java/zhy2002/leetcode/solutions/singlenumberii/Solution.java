package zhy2002.leetcode.solutions.singlenumberii;

/**
 * https://leetcode.com/problems/single-number-ii/
 * The general idea is count the number of 1s at each bit, if the count goes to 3 then wrap back to 0.
 * We can use a int[32] counts to solve n-single number problem in general (n=2, 3, 4, ...) but this will have a huge overhead (albeit still linear).
 * The generic solution can be found at:
 * http://fisherlei.blogspot.com.au/2013/11/leetcode-single-number-ii-solution.html
 */
public class Solution {

    //Optimised solution with bit hack.
    public int singleNumber(int[] A) {

        //bit vectors used to count number of bits for the sum
        int one = 0;//bit is 1 if the bit has appeared once
        int two = 0;//bit is 1 if the bit has appeared twice

        for (int val : A) {
            int nextOne = one ^ val;//could be 1 or 3 times
            int nextTwo = (one & val) | (two & ~val);//the bits that appeared two times are: 1) previously appeared once and is also set in val; 2) previously appeared twice but not set in val
            int threeMask = ~(nextOne & two);//clear those bits appeared 1+2 times
            one = nextOne & threeMask; //clear bits appeared 3 times
            two = nextTwo;
        }
        return one;

    }
}
