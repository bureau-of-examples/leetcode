package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/palindrome-pairs/description/
 */
public class PalindromePairsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                Utils.listOfListToString(solution.palindromePairs(new String[]{"a", ""})),
                equalTo("[[1,0],[0,1]]")
        );
        assertThat(
                Utils.listOfListToString(solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})),
                equalTo("[[1,0],[0,1],[3,2],[2,4]]")
        );

        assertThat(
                Utils.listOfListToString(solution.palindromePairs(new String[]{"bat", "tab", "cat"})),
                equalTo("[[1,0],[0,1]]")
        );

    }

    public class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            Map<String, Integer> wordToIndex = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                wordToIndex.put(words[i], i);
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                //for each word, find another string left such that left + word is palindrome.
                for (int bound = 1; bound < word.length(); bound++) {
                    String mid = word.substring(0, bound);
                    if (isPalindrome(mid)) {
                        String right = word.substring(bound);
                        String left = reverse(right);
                        if (wordToIndex.containsKey(left)) {
                            int leftIndex = wordToIndex.get(left);
                            if (leftIndex != i) {
                                result.add(Arrays.asList(leftIndex, i));
                            }
                        }
                    }
                }
                for (int bound = word.length() - 1; bound >= 1; bound--) {
                    String mid = word.substring(bound, word.length());
                    if (isPalindrome(mid)) {
                        String left = word.substring(0, bound);
                        String right = reverse(left);
                        if (wordToIndex.containsKey(right)) {
                            int rightIndex = wordToIndex.get(right);
                            if (rightIndex != i) {
                                result.add(Arrays.asList(i, rightIndex));
                            }
                        }
                    }
                }
                if (isPalindrome(word)) {
                    if (wordToIndex.getOrDefault("", i) != i) {
                        result.add(Arrays.asList(wordToIndex.get(""), i));
                        result.add(Arrays.asList(i, wordToIndex.get("")));
                    }
                }
                String rev = reverse(word);
                if (wordToIndex.getOrDefault(rev, i) != i) {
                    result.add(Arrays.asList(wordToIndex.get(rev), i));
                }
            }
            return result;
        }

        private boolean isPalindrome(String str) {
            int start = 0, end = str.length() - 1;
            while (start < end) {
                if (str.charAt(start) != str.charAt(end))
                    return false;
                start++;
                end--;
            }
            return true;
        }

        private String reverse(String str) {
            char[] chars = str.toCharArray();
            int start = 0, end = chars.length - 1;
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            return new String(chars);
        }
    }

}
