package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
/**
 * https://leetcode.com/problems/valid-word-square/#/description
 */
public class ValidWordSquareTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.validWordSquare(Arrays.asList("abcd","bnrt","crmy","dtye")), equalTo(true));
    }

    public class Solution {
        public boolean validWordSquare(List<String> words) {
            int max = 0;
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).length() > max) {
                    max = words.get(i).length();
                }
            }
            if (max != words.size())
                return false;

            for (int i = 0; i < max; i++) {
                if (!verify(words, i))
                    return false;
            }
            return true;
        }

        private boolean verify(List<String> words, int r) {
            String row = words.get(r);
            for (int i = 0; i < words.size(); i++) { //verify column
                Character ch1 = getChar(row, i);
                Character ch2 = getChar(words.get(i), r);
                if (!Objects.equals(ch1, ch2))
                    return false;
            }
            return true;
        }

        private Character getChar(String word, int i) {
            if (i >= word.length())
                return null;
            return word.charAt(i);
        }
    }
}
