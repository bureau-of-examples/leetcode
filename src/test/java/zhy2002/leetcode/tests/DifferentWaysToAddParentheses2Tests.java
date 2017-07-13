package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/#/description
 */
public class DifferentWaysToAddParentheses2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.diffWaysToCompute("2*3-4*5"), equalTo(Arrays.asList(-34, -10, -14, -10, 10)));
        assertThat(solution.diffWaysToCompute("2-1-1"), equalTo(Arrays.asList(2, 0)));
        assertThat(solution.diffWaysToCompute("2*3+4"), equalTo(Arrays.asList(14, 10)));
        assertThat(solution.diffWaysToCompute("1+1+2"), equalTo(Arrays.asList(4, 4)));
        assertThat(solution.diffWaysToCompute("1+1"), equalTo(Arrays.asList(2)));
        assertThat(solution.diffWaysToCompute("1"), equalTo(Arrays.asList(1)));
    }

    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> result = new ArrayList<>();
            boolean foundOp = false;
            for (int i = 0; i < input.length(); i++) {
                if (isOperator(input.charAt(i))) {
                    foundOp = true;
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                    List<Integer> computed = join(left, right, input.charAt(i));
                    result.addAll(computed);
                }
            }
            if (!foundOp) {
                result.add(Integer.parseInt(input));
            }
            return result;
        }

        private List<Integer> join(List<Integer> left, List<Integer> right, char op) {
            List<Integer> result = new ArrayList<>();
            for (Integer l : left) {
                for (Integer r : right) {
                    result.add(calc(l, r, op));
                }
            }
            return result;
        }

        private int calc(int l, int r, char op) {
            if (op == '+') {
                return l + r;
            } else if (op == '-') {
                return l - r;
            } else if (op == '*') {
                return l * r;
            }
            throw new RuntimeException("No way..");
        }

        private boolean isOperator(char ch) {
            return ch == '+' || ch == '-' || ch == '*';
        }
    }
}
