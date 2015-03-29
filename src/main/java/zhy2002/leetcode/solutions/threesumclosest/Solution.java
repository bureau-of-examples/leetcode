package zhy2002.leetcode.solutions.threesumclosest;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class Solution {

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int smallestDiff = Integer.MAX_VALUE;
        Integer closestSum = null;

        for (int i = num.length - 3; i >= 0; i--) {
            int j = i + 1, k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == target)
                    return target;

                int diff;
                if (sum > target) {
                    diff = sum - target;
                    k--;
                } else {
                    diff = target - sum;
                    j++;
                }
                if (diff < smallestDiff) {
                    smallestDiff = diff;
                    closestSum = sum;
                }
            }
        }
        if (closestSum == null)
            throw new RuntimeException("Result not found.");
        return closestSum;
    }
}
