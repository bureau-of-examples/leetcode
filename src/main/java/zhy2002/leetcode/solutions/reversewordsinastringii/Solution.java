package zhy2002.leetcode.solutions.reversewordsinastringii;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 */
public class Solution {

    //reverse the whole string, then reverse each word
    //e.g. the sky is blue -> eulb si yks eht -> blue is the sky
    public void reverseWords(char[] s) {

        int start = 0, end = s.length - 1;

        //reverse
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

        //reverse back each word
        start = 0;
        end = 1;
        while (start < s.length) {
            while (end < s.length && !Character.isWhitespace(s[end]))
                end++;
            int swapEnd = end - 1;
            while (start < swapEnd) {
                char temp = s[start];
                s[start] = s[swapEnd];
                s[swapEnd] = temp;
                start++;
                swapEnd--;
            }
            start = end + 1;
            end = start + 1;
        }

    }
}
