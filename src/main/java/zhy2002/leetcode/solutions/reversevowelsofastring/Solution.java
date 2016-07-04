package zhy2002.leetcode.solutions.reversevowelsofastring;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && !isVowel(chars[start])) {
                start++;
            }

            while (start < end && !isVowel(chars[end])) {
                end--;
            }

            if(start < end) {
                char ch = chars[start];
                chars[start] = chars[end];
                chars[end] = ch;
                start++;
                end --;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
