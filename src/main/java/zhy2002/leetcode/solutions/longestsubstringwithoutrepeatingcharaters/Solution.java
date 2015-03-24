package zhy2002.leetcode.solutions.longestsubstringwithoutrepeatingcharaters;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Maintain a maximum window that contains distinct characters.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> lastIndexSoFar = new HashMap<>();
        int maxLen = 1, start = 0, end = 1;//window is [start, end)
        lastIndexSoFar.put(s.charAt(0), 0);

        //find max none repeating substring end at end
        for (; end < s.length(); end++) {
            Character ch = s.charAt(end);
            Integer lastIndex = lastIndexSoFar.get(ch);
            if (lastIndex == null || lastIndex < start) {//new char
                lastIndexSoFar.put(ch, end);
                int width = end - start + 1;
                if(width > maxLen)
                    maxLen = width;
            } else {
                start = lastIndex + 1;
                lastIndexSoFar.put(ch, end);//width will decrease
            }
        }
        return maxLen;
    }
}
