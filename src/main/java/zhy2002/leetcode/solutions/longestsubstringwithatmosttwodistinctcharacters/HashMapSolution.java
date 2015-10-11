package zhy2002.leetcode.solutions.longestsubstringwithatmosttwodistinctcharacters;

import java.util.HashMap;

/**
 * This is a generic solution to tracking a sliding window of n distinct characters.
 * Use a hash map to track how many times a character occurs in the sliding window. The counter is removed when it decreases to 0.
 * This algorithm still runs in linear time however it is slower that the specialized two pointer version.
 */
public class HashMapSolution implements Solution {

    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int start = 0, end = 1;
        int maxLen = 1;
        HashMap<Character, Integer> chCounts = new HashMap<>(); //counters of characters in the sliding window
        chCounts.put(s.charAt(start), 1);
        for (; end < s.length(); end++) {
            Character ch = s.charAt(end);
            Integer count = chCounts.get(ch);
            chCounts.put(ch, count == null ? 1 : count + 1);
            while (chCounts.size() > 2) {//the character added breaks the sliding window property - so add just the left border of the window until the property is met again.
                ch = s.charAt(start);
                count = chCounts.get(ch) - 1;
                if (count == 0)
                    chCounts.remove(ch);
                else
                    chCounts.put(ch, count);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;

    }

}
