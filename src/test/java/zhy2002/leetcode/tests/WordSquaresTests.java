package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/word-squares/description/
 */
public class WordSquaresTests {

    @Test
    public void test() {
        TleSolution solution = new TleSolution();

        assertThat(
                Utils.listOfListToString(
                        solution.wordSquares(new String[]{"abat", "baba", "atan", "atal"})
                ),
                equalTo("[[baba,abat,baba,atan],[baba,abat,baba,atal]]")
        );

        assertThat(
                Utils.listOfListToString(
                        solution.wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"})
                ),
                equalTo("[[wall,area,lead,lady],[ball,area,lead,lady]]")
        );
    }

    class TleSolution {
        public List<List<String>> wordSquares(String[] words) {
            int n = words[0].length();
            List<List<String>> result = new ArrayList<>();
            find(result, words, n, new ArrayList<>());
            return result;
        }

        private void find(List<List<String>> result, String[] words, int n, List<String> buffer) {
            if (buffer.size() == n) {
                result.add(new ArrayList<>(buffer));
                return;
            }

            for (int i = 0; i < words.length; i++) {
                buffer.add(words[i]);
                if (check(buffer)) {
                    find(result, words, n, buffer);
                }
                buffer.remove(buffer.size() - 1);
            }
        }

        private boolean check(List<String> buffer) {
            if (buffer.size() == 1)
                return true;

            int row = buffer.size() - 1;
            String last = buffer.get(row);
            for (int col = 0; col < row; col++) {
                if (last.charAt(col) != buffer.get(col).charAt(row))
                    return false;
            }
            return true;
        }
    }
}
