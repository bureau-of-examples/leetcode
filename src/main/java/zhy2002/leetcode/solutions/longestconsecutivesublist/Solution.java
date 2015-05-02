package zhy2002.leetcode.solutions.longestconsecutivesublist;

/**
 * This is my own question that is derived from the Leetcode question Longest Consecutive Sequence.
 * Find the length of the longest sub-list whose values are consecutive.
 * E.g. 1,2,3,2,3 is consecutive.
 * Next value should be lastValue +- 1.
 */
public class Solution {

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        int lastVal = num[0];
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < num.length; i++) {
            if (num[i] == lastVal + 1 || num[i] == lastVal - 1) {
                count++;
                lastVal = num[i];
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                lastVal = num[i];
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }

        return maxCount;
    }
}
