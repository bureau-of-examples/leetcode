package zhy2002.leetcode.solutions.trailingzeroes;

/**
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * All integers can be represented by the product of its prime factors.
 * A trailing zero is produced when there is a 2 and a 5.
 * As we multiply from 1 to n, we notice that the number of factor 2 is always greater than the number of factor 5.
 * So all we need to do is to count the number of 5 factors.
 */
public class Solution {

    public int trailingZeroes(int n) {
        int count5 = 0;
        long step = 5;
        while (true){
            long count = n / step; //number of step multiples
            if(count == 0)
                break;
            count5 += count;
            step *= 5;
        }
        return count5; //= 5 multiples + 25 multiples + 125 multiples...
    }
}
