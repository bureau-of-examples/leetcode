package zhy2002.leetcode.solutions.powerofthree;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?v
 */
public class Solution {

    //1162261467 has only factor 3 if n has any factor other than 3 then result will not be an integer.
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0; //1162261467=3^19 which is the biggest 3 power with in int range.
    }
}
