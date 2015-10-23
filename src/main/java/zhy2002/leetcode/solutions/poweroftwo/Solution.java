package zhy2002.leetcode.solutions.poweroftwo;

/**
 * https://leetcode.com/problems/power-of-two/
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Solution {


    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;

        return n - (n & (-n)) == 0; //(n & (-n)) = isolate the right most bit

    }
}
