package zhy2002.leetcode.solutions.missingnumber;

/**
 * https://leetcode.com/problems/missing-number/
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {

    //missing_number XOR array = XOR(0 to n)
    public int missingNumber(int[] nums) {
        int xorAll = 0;
        for(int i=0; i<=nums.length; i++){
            xorAll ^= i;
        }

        int xorArray = 0;
        for(int i=0; i<nums.length; i++){
            xorArray ^= nums[i];
        }

        return xorAll ^ xorArray;
    }
}
