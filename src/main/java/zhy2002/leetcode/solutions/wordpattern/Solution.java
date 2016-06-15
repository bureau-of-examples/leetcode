package zhy2002.leetcode.solutions.wordpattern;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Solution {

    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split("\\s");
        if (pattern.length() != words.length)
            return false;

        HashMap<Character, String> wordMap = new HashMap<>();
        HashSet<String> mappedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            String word = words[i];
            if (wordMap.containsKey(ch)) {
                if (!wordMap.get(ch).equals(word))
                    return false;
            } else {
                if (mappedWords.contains(word)) {
                    return false;
                } else {
                    wordMap.put(ch, word);
                    mappedWords.add(word);
                }
            }
        }
        return true;
    }
}
