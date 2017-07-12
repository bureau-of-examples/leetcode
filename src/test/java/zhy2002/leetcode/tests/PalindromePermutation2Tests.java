package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/palindrome-permutation/#/description
 */
public class PalindromePermutation2Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (Character ch : s.toCharArray()) {
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }

            int oddCount = 0;
            for (Integer count : frequency.values()) {
                if (count % 2 == 1) {
                    oddCount++;
                }
            }
            return oddCount <= 1;
        }
    }

}
