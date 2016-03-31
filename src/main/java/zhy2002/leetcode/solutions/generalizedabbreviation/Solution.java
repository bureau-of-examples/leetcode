package zhy2002.leetcode.solutions.generalizedabbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * <p>
 * The idea is:
 * In the word, turn off a char by setting it to 1.
 * We want to enumerate all possible ways to turn off chars.
 * Then normalize a processed word by combining the adjacent 1s.
 */
public class Solution {

    /**
     * This has overlapping sub-problems (e.g. wo... & 1o...) so try bottom up DP.
     * Start from an empty string, one by one add chars from front to back.
     */
    public List<String> generateAbbreviations(String word) {

        //grow
        Abbr first = new Abbr(0, "");
        for (char ch : word.toCharArray()) {

            Abbr newFirst = new Abbr(0, ""); //sentinel
            Abbr newLast = newFirst;

            while (first != null) {
                newLast.next = new Abbr(0, first.toString() + ch);
                newLast = newLast.next;
                newLast.next = new Abbr(first.trailingNumber + 1, first.prefix);
                newLast = newLast.next;

                first = first.next;
            }

            first = newFirst.next;
        }

        //harvest
        List<String> result = new ArrayList<>();
        while (first != null) {
            result.add(first.toString());
            first = first.next;
        }
        return result;
    }

    class Abbr {

        final int trailingNumber;
        final String prefix;
        Abbr next;

        public Abbr(int trailingNumber, String suffix) {
            this.trailingNumber = trailingNumber;
            this.prefix = suffix;
        }

        @Override
        public String toString() {
            return trailingNumber > 0 ? prefix + String.valueOf(trailingNumber) : prefix;
        }
    }

}
