package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/is-subsequence/#/description
 */
public class IsSubsequenceTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0)
                return true;
            int sIndex = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(sIndex)) {
                    sIndex++;
                }
                if (sIndex == s.length())
                    return true;
            }
            return false;
        }
    }

    @Test
    public void testContest() {
        SolutionContest solution = new SolutionContest();
        assertThat(solution.exclusiveTime(
                2,
                Arrays.asList(
                        "0:start:0",
                        "1:start:2",
                        "1:end:5",
                        "0:end:6"
                )
        ), equalTo(new int[]{3, 4}));
    }

    public class SolutionContest {

        private class Pair {
            int funcId;
            int startTime;

            Pair(int funcId, int startTime) {
                this.funcId = funcId;
                this.startTime = startTime;
            }
        }

        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];
            Stack<Pair> stack = new Stack<>();
            for (String log : logs) {
                int[] parsed = parse(log);
                if (parsed[1] == 0) {
                    stack.push(new Pair(parsed[0], parsed[2]));
                } else {
                    Pair pair = stack.pop();
                    assert pair.funcId == parsed[0];
                    result[pair.funcId] += parsed[2] - pair.startTime;
                    if (!stack.isEmpty()) {
                        result[stack.peek().funcId] -= parsed[2] - pair.startTime;
                    }
                }
            }

            return result;
        }

        private int[] parse(String log) {
            int[] result = new int[3];
            String[] parts = log.split(":");
            result[0] = Integer.parseInt(parts[0]);
            result[1] = "start".equals(parts[1]) ? 0 : 1;
            result[2] = Integer.parseInt(parts[2]);
            return result;
        }
    }
}
