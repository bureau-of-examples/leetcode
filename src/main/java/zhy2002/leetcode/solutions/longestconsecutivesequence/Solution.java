package zhy2002.leetcode.solutions.longestconsecutivesequence;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class Solution {

    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0;
        for (int value : num) {
            set.add(value);
        }
        for (int value : num) {
            if (!set.contains(value))
                continue;

            //starting from which consecutive element does not matter
            int count = 1;
            int left = value - 1;
            while (set.contains(left)) {//search back
                count++;
                set.remove(left);
                left--;
            }

            int right = value + 1;
            while (set.contains(right)) {//search forward
                count++;
                set.remove(right);
                right++;
            }

            if (count > maxCount) {
                maxCount = count;
            }

            set.remove(value);

        }
        return maxCount;
    }

}
