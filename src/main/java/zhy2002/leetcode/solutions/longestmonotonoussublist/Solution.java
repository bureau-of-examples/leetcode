package zhy2002.leetcode.solutions.longestmonotonoussublist;

/**
 * This is my own question that is derived from the Leetcode question Longest Consecutive Sequence.
 * Find the length of the longest monotonously consecutive sub-list.
 * E.g. 1,2,3,4 or 4,3,2,1 is monotonously consecutive but 1,2,3,5 or 1,2,3,2 is not.
 */
public class Solution {

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        if (num.length == 1)
            return 1;

        int val = num[0];
        int count = num[1] - num[0] >= 0 ? 1 : -1;
        int maxCount = 1;

        for (int i = 1; i < num.length; i++) {
            if (num[i] == val + count) {
                if (count > 0)
                    count++;
                else
                    count--;
            } else {
                if (Math.abs(count) > maxCount) {
                    maxCount = Math.abs(count);
                }

                if (num[i - 1] + 1 == num[i]) {
                    val = num[i - 1];
                    count = 2;
                } else if (num[i - 1] - 1 == num[i]) {
                    val = num[i - 1];
                    count = -2;
                } else {
                    val = num[i];
                    if (i + 1 < num.length) {
                        count = num[i + 1] - num[i] >= 0 ? 1 : -1;
                    } else {
                        count = 1;//last one
                    }
                }
            }
        }
        if (Math.abs(count) > maxCount) {
            maxCount = Math.abs(count);
        }

        return maxCount;
    }

}
