package zhy2002.leetcode.solutions.validanagram;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Solution {

    private int[] buffer = new int[26];

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        Arrays.fill(buffer, 0);
        for (char ch : s.toCharArray()) {
            buffer[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            buffer[ch - 'a']--;
        }

        for (int i : buffer) {
            if (i != 0)
                return false;
        }

        return true;

    }

}
