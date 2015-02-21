package zhy2002.leetcode.solutions.reversewordsinastring;

/**
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * from end to start, scan the whole string:
 * use wordStart and wordEnd pointers to find beginning and end of words.
 */
public class Solution {

    public String reverseWords(String s) {

        if (s == null)
            throw new IllegalArgumentException("s");

        StringBuilder sentenceBuilder = new StringBuilder();
        int wordStart = -1;
        int wordEnd = -1;

        s = " " + s;//space serves as a sentinel
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isWhitespace(ch)) {
                if (wordEnd != -1) {
                    if (sentenceBuilder.length() > 0)
                        sentenceBuilder.append(' '); //pad whitespace before output the current word
                    while (wordStart <= wordEnd) {
                        sentenceBuilder.append(s.charAt(wordStart));
                        wordStart++;
                    }

                    wordEnd = wordStart = -1;
                }
            } else {
                if (wordEnd == -1) {
                    wordEnd = wordStart = i;
                } else {
                    wordStart--;
                }
            }
        }

        return sentenceBuilder.toString();
    }

}
