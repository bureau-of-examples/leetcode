package zhy2002.leetcode.solutions.singlenumberiii;

/**
 * https://leetcode.com/problems/single-number-iii/
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * For example:
 *
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class Solution {

    public int[] singleNumber(int[] nums) {

        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor ^= nums[i];
        }

        int mask = xor & -xor; //isolate right most 1 bit
        int xor1 = 0, xor2 = 0;
        for(int i=0; i<nums.length; i++){
            if((nums[i] & mask) == 0){
                xor1 ^= nums[i];
            } else {
                xor2 ^= nums[i];
            }
        }

        if(xor1 < xor2){
            return new int[]{xor1, xor2};
        } else {
            return new int[]{xor2, xor1};
        }
    }
}
