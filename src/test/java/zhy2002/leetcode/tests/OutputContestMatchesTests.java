package zhy2002.leetcode.tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import zhy2002.leetcode.solutions.outputcontestmatches.LinearSolution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/output-contest-matches/#/description
 */
public class OutputContestMatchesTests {

    @Test
    public void test() {
        LinearSolution solution = new LinearSolution();

        assertThat(solution.findContestMatch(2), equalTo("(1,2)"));
        assertThat(solution.findContestMatch(4), equalTo("((1,4),(2,3))"));
        assertThat(solution.findContestMatch(8), equalTo("(((1,8),(4,5)),((2,7),(3,6)))"));
    }

    public class Solution {

        private class Pair {
            private Object first;
            private Object second;

            Pair(Object first, Object second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public String toString() {
                return String.format("(%s,%s)", first, second);
            }
        }

        public String findContestMatch(int n) {
            int start = 1, end = n;
            List<Pair> round = new ArrayList<>();
            while (start < end) {
                round.add(new Pair(start, end));
                start++;
                end--;
            }
            while (round.size() != 1) {
                List<Pair> newRound = new ArrayList<>();
                start = 1;
                end = round.size();
                while (start < end) {
                    newRound.add(new Pair(round.get(start - 1), round.get(end - 1)));
                    start++;
                    end--;
                }
                round = newRound;
            }
            return round.get(0).toString();
        }
    }
}
