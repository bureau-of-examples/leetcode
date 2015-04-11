package zhy2002.leetcode.solutions.decodeways;

/**
 * https://leetcode.com/problems/decode-ways/
 * DP solution. number of ways to decode up to i + 1 = number of ways to decode up to i if s[i+1] is valid code + number of ways to decode up to i - 1 if s[i~i+1] is valid code..
 */
public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int previousWays = 1;//number of ways to decode up to i-1
        int current = 0;//number of ways to decode up to i
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch > '9' || ch < '0')//illegal char
                return 0;
            if (i == 0) {//first cannot be 0
                if (ch == '0')
                    return 0;
                current = 1;
            } else {
                if (previousWays == 0 && current == 0)
                    return 0;

                int newCurrent = 0;
                if (ch != '0')
                    newCurrent += current;

                char previousChar = s.charAt(i - 1);
                int combinedValue = previousChar == '0' ? 0 : (previousChar - '0') * 10 + (ch - '0');
                if (combinedValue >= 1 && combinedValue <= 26) {
                    newCurrent += previousWays;
                }
                previousWays = current;
                current = newCurrent;
            }
        }
        return current;

    }

}
