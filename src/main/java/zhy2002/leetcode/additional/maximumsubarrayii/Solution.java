package zhy2002.leetcode.additional.maximumsubarrayii;

/**
 * https://leetcode.com/forums/viewtopic.php?f=4&t=149&sid=e69007f82f110cd2995ff8f33b539cec
 *
 * Find the contiguous subarray within a cyclic array (containing at least one number) which has the largest sum.
 * For example, given the array [4,−4,3,−8,3,−1,2], the contiguous subarray [4,2,−1,3] has the largest sum = 8.
 *
 * The maximum subarray is either:
 * does not go across the cyclic border - find with the normal maximum subarray algorithm
 * does go across the cyclic border - find the normal minimum subarray, then the rest element form the maximum subarray
 */
public class Solution {

    public int maxContiguous(int[] array) {
        int len = array.length;

        //get normal max - the well know linear algorithm.
        int max = array[0];
        int maxHere = max;
        for (int i = 1; i < len; i++) {
            if (maxHere < 0) {
                maxHere = array[i];
            } else {
                maxHere += array[i];
            }

            if (maxHere > max)
                max = maxHere;
        }

        //get sum
        int sum = 0;
        for (int v : array) {
            sum += v;
        }

        //get normal min
        int min = array[0];
        int minHere = min;
        for (int i = 1; i < len; i++) {
            if (minHere > 0) {
                minHere = array[i];
            } else {
                minHere += array[i];
            }

            if (minHere < min)
                min = minHere;
        }

        return Math.max(sum - min, max);


    }

}
