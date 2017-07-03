package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/#/description
 */
public class FirstUniqueCharacterInAStringTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int firstUniqChar(String s) {
            int[] counts = new int[26];
            for (char ch : s.toCharArray()) {
                counts[ch - 'a']++;
            }

            for (int i = 0; i < s.length(); i++) {
                if (counts[s.charAt(i) - 'a'] == 1)
                    return i;
            }

            return -1;
        }
    }

}
