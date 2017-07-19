package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class ExclusiveTimeOfFunctionsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.exclusiveTime(2, Arrays.asList(
                "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"
        )), equalTo(new int[]{3, 4}));
    }

    public class Solution {
        private class CallStart {
            private int funcId;
            private int startTime;

            CallStart(int funcId, int startTime) {
                this.funcId = funcId;
                this.startTime = startTime;
            }
        }

        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];
            Stack<CallStart> stack = new Stack<>();
            for (String log : logs) {
                int[] parsed = parse(log);
                if (parsed[1] == 0) {
                    stack.push(new CallStart(parsed[0], parsed[2]));
                } else {
                    assert stack.peek().funcId == parsed[0];
                    CallStart callStart = stack.pop();
                    int time = parsed[2] - callStart.startTime + 1;
                    result[callStart.funcId] += time;
                    if (!stack.isEmpty()) {
                        result[stack.peek().funcId] -= time;
                    }
                }
            }
            return result;
        }

        private int[] parse(String log) {
            String[] parts = log.split(":");
            return new int[]{
                    Integer.parseInt(parts[0]),
                    "start".equals(parts[1]) ? 0 : 1,
                    Integer.parseInt(parts[2])
            };
        }
    }

}
