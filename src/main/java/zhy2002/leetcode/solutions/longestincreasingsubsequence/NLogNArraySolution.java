package zhy2002.leetcode.solutions.longestincreasingsubsequence;

import java.util.Arrays;

/**
 * Same as NLogNSolution but with array.
 */
public class NLogNArraySolution implements Solution {
    @Override
    public int lengthOfLIS(int[] nums) {

        int[] minEndElements = new int[nums.length];
        int size = 0;
        for(int num : nums) {
            if(size == 0 || minEndElements[size - 1] < num) {
                minEndElements[size++] = num;
            } else {
                int pos = Arrays.binarySearch(minEndElements, 0, size, num);
                if(pos < 0) {
                    minEndElements[-pos - 1] = num;
                }
            }
        }
        return size;
    }
}
