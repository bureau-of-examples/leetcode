package zhy2002.leetcode.solutions.longestsubstringwithatmostkdistinctcharacters;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 */
public class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0)
            return 0;

        int start = 0, maxLen = 0;
        HashMap<Character, Integer> charCount = new HashMap<>(); //count of chars in [start, end]
        for (int end = 0; end < s.length(); end++) {
            Character chEnd = s.charAt(end);
            Integer count = charCount.get(chEnd);

            if (count != null || charCount.size() < k) {
                charCount.put(chEnd, (count == null ? 0 : count) + 1);
                maxLen = Math.max(maxLen, end - start + 1);
            } else { //move start index to exclude a char
                while (charCount.size() == k) {
                    Character chStart = s.charAt(start++);
                    int chStartCount = charCount.get(chStart);
                    if (chStartCount == 1) {
                        charCount.remove(chStart);
                    } else {
                        charCount.put(chStart, chStartCount - 1);
                    }
                }
                charCount.put(chEnd, 1);
            }
        }
        return maxLen;
    }
}
