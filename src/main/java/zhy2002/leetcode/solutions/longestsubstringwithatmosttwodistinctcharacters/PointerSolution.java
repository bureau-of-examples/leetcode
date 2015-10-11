package zhy2002.leetcode.solutions.longestsubstringwithatmosttwodistinctcharacters;

/**
 * Keep tracking a sliding window which contains at most two distinct characters.
 * Usa two pointers ch1LastIndex and ch2LastIndex so that we know how to adjust the sliding window.
 * ch1 is the first char in the sliding window, and ch2 is the second.
 */
public class PointerSolution implements Solution {

    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int start = 0;
        char ch1 = s.charAt(0); //eliminate this char when [start, end] contains > 2 distinct chars
        int ch1LastIndex = 0;
        char ch2 = ch1;
        int ch2LastIndex = 0;
        int maxLen = 1;

        for (int end = 1; end < s.length(); end++) {
            char ch = s.charAt(end);

            if (ch1 == ch2) {//try to populate ch2
                if (ch == ch1) {
                    ch1LastIndex = end;
                } else {
                    ch2 = ch;
                    ch2LastIndex = end;
                }
            } else {
                if (ch == ch1) {
                    ch1LastIndex = end;//swap ch1 and ch2; now we want to eliminate ch2 first
                    char tempCh = ch1;
                    ch1 = ch2;
                    ch2 = tempCh;
                    int tempInt = ch1LastIndex;
                    ch1LastIndex = ch2LastIndex;
                    ch2LastIndex = tempInt;
                } else if (ch == ch2) {
                    ch2LastIndex = end;
                } else { //resize the sliding winow by eliminating ch1
                    start = ch1LastIndex + 1;
                    ch1 = ch2;
                    ch1LastIndex = ch2LastIndex;
                    ch2 = ch;
                    ch2LastIndex = end;
                }
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;

    }

}
