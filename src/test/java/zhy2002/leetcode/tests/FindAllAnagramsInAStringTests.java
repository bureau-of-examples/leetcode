package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/#/description
 */
public class FindAllAnagramsInAStringTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findAnagrams("cbaebabacd", "abc"), equalTo(Arrays.asList(0, 6)));
        assertThat(solution.findAnagrams("bbbaaa", "aaa"), equalTo(Arrays.asList(3)));
        assertThat(solution.findAnagrams("bbbcaaabca", "cba"), equalTo(Arrays.asList(2, 6, 7)));
    }

    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length())
                return Collections.emptyList();

            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> counts = new HashMap<>();
            for (char ch : p.toCharArray()) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }
            int totalPositiveCount = p.length();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int count = counts.getOrDefault(ch, 0);
                counts.put(ch, count - 1);
                if (count > 0) {
                    totalPositiveCount--;
                }
                int start = i - p.length() + 1;
                if (start >= 0) {
                    if (totalPositiveCount == 0) {
                        result.add(start);
                    }
                    char ch2 = s.charAt(start);
                    int count2 = counts.getOrDefault(ch2, 0);
                    counts.put(ch2, count2 + 1);
                    if (count2 >= 0) {
                        totalPositiveCount++;
                    }
                }
            }

            return result;
        }
    }

}
