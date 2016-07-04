package zhy2002.leetcode.solutions.reversestring;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Solution {

    public String reverseString(String s) {
        if(s.length() == 0)
            return "";

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            //swap
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
