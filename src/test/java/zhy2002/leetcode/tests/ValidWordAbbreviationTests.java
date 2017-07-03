package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/valid-word-abbreviation/#/description
 */
public class ValidWordAbbreviationTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.validWordAbbreviation("a", "01"), equalTo(false));
        assertThat(solution.validWordAbbreviation("word", "word"), equalTo(true));
        assertThat(solution.validWordAbbreviation("word", "wor1"), equalTo(true));
        assertThat(solution.validWordAbbreviation("word", "1o1d"), equalTo(true));
        assertThat(solution.validWordAbbreviation("internationalization", "i12iz4n"), equalTo(true));
        assertThat(solution.validWordAbbreviation("apple", "a2e"), equalTo(false));
    }

    public class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int wIndex = 0;
            for (int i = 0; i < abbr.length(); i++) {
                char p = abbr.charAt(i);
                if (Character.isLetter(p) || p == '0') {
                    if (wIndex >= word.length() || word.charAt(wIndex) != p)
                        return false;
                    wIndex++;
                } else {
                    int endIndex = i + 1;
                    while (endIndex < abbr.length() && Character.isDigit(abbr.charAt(endIndex))) {
                        endIndex++;
                    }
                    int count = Integer.parseInt(abbr.substring(i, endIndex));
                    i = endIndex - 1;
                    for (int j = 0; j < count; j++) {
                        if (wIndex >= word.length())
                            return false;
                        wIndex++;
                    }
                }
            }
            return wIndex == word.length();
        }
    }
}
