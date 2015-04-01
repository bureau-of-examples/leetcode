package zhy2002.leetcode.solutions.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Use two pointer scan S wordLen times.
 */
public class Solution {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();
        int wordLen = L[0].length(); //assume L is not empty
        int subStrLen = wordLen * L.length;
        if (S.length() < subStrLen)
            return result;

        //count words in L
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : L) {
            Integer count = wordCount.get(word);
            wordCount.put(word, count == null ? 1 : count + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            if (S.length() < subStrLen + i) //not enough for 1 substring
                break;

            int start = i, end = i;//index of next word
            while (true) {
                String nextWord = S.substring(end, end + wordLen);
                Integer count = wordCount.get(nextWord);
                if (count == null) {
                    while (start < end) {
                        String capturedWord = S.substring(start, start + wordLen);
                        wordCount.put(capturedWord, wordCount.get(capturedWord) + 1);
                        start += wordLen;
                    }
                    start += wordLen;
                } else if (count == 0) {
                    do {
                        String capturedWord = S.substring(start, start + wordLen);
                        if (capturedWord.equals(nextWord)) {
                            start += wordLen;
                            break;
                        } else {
                            wordCount.put(capturedWord, wordCount.get(capturedWord) + 1);
                            start += wordLen;
                        }
                    } while (start < end);
                } else {
                    wordCount.put(nextWord, count - 1);
                    if (end + wordLen - start == subStrLen) {
                        result.add(start);

                        String capturedWord = S.substring(start, start + wordLen);
                        wordCount.put(capturedWord, wordCount.get(capturedWord) + 1);
                        start += wordLen;

                    }
                }
                end += wordLen;
                if (S.length() < start + subStrLen || S.length() < end + wordLen) {
                    while (start < end) {
                        String capturedWord = S.substring(start, start + wordLen);
                        wordCount.put(capturedWord, wordCount.get(capturedWord) + 1);
                        start += wordLen;
                    }
                    break;
                }
            }
        }

        return result;
    }

}
