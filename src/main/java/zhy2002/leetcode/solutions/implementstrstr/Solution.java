package zhy2002.leetcode.solutions.implementstrstr;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/implement-strstr/
 * bmh algorithm.
 */
public class Solution {

    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null)
            return -1;
        if (needle.length() == 0)
            return 0;

        if (needle.length() > haystack.length())
            return -1;

        if (needle.length() == haystack.length())
            return needle.compareTo(haystack) == 0 ? 0 : -1;

        //map of ch => shift where shift is the number of moves needed to move the cursor from the end of needle to the last occurrence of ch.
        HashMap<Character, Integer> badCharShift = new HashMap<>();
        for (int i = 0; i < needle.length() - 1; i++) {
            badCharShift.put(needle.charAt(i), needle.length() - 1 - i);
        }

        int hayIndex = needle.length() - 1;
        while (hayIndex < haystack.length()) {
            int needIndex = needle.length() - 1;

            while (haystack.charAt(hayIndex) == needle.charAt(needIndex)) {
                if (needIndex == 0)
                    return hayIndex;
                hayIndex--;
                needIndex--;
            }

            int hayCmpLastIndex = hayIndex + needle.length() - needIndex - 1;
            Integer shift = badCharShift.get(haystack.charAt(hayCmpLastIndex));
            if (shift == null)
                shift = needle.length();
            hayIndex = hayCmpLastIndex + shift;//so that haystack.charAt(hayCmpLastIndex) is aligned with the last occurrence of the same char in needle.
        }

        return -1;
    }
}
