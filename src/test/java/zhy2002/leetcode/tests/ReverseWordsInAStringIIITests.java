package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description
 */
public class ReverseWordsInAStringIIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.reverseWords("Let's take LeetCode contest"), equalTo("s'teL ekat edoCteeL tsetnoc"));
        assertThat(solution.reverseWords("    "), equalTo("    "));
        assertThat(solution.reverseWords(" word"), equalTo(" drow"));
        assertThat(solution.reverseWords("a b c d"), equalTo("a b c d"));
        assertThat(solution.reverseWords(" ac b cbs d "), equalTo(" ca b sbc d "));
    }

    public class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int index = 0;
            while (index < chars.length) {
                if (Character.isWhitespace(chars[index])) {
                    index++;
                    continue;
                }
                int end = index + 1;
                while (end < chars.length && !Character.isWhitespace(chars[end])) {
                    end++;
                }
                swap(chars, index, end - 1);
                index = end + 1;
            }

            return new String(chars);
        }

        private void swap(char[] chars, int i, int j) {
            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
    }

}
