package zhy2002.leetcode.solutions.lengthoflastword;

/**
 * https://leetcode.com/problems/length-of-last-word/.
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int realLength = s.length();
        while (realLength > 0 && Character.isWhitespace(s.charAt(realLength - 1)))
            realLength--;

        int count = 1;
        while (count <= realLength) {
            if (Character.isWhitespace(s.charAt(realLength - count)))
                break;
            count++;
        }

        return count - 1;
    }
}
