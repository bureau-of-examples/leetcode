package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/solve-the-equation/#/description
 */
public class SolveTheEquationTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.solveEquation("x+5-3+x=6+x-2"), equalTo("x=2"));
    }

    public class Solution {
        public String solveEquation(String equation) {
            String[] parts = equation.split("=");
            int[] left = parse(parts[0]);
            int[] right = parse(parts[1]);
            int totalX = left[0] - right[0];
            int totalNum = right[1] - left[1];
            if (totalX == 0) {
                return totalNum == 0 ? "Infinite solutions" : "No solution";
            }
            return "x=" + (totalNum / totalX);
        }

        private int[] parse(String part) {
            int xCount = 0;
            int numCount = 0;
            int start = 0;
            for (int end = 0; end < part.length(); end++) {
                char ch = part.charAt(end);
                if (ch == 'x') {
                    if (start < end) {
                        if (Character.isDigit(part.charAt(end - 1))) {
                            xCount += Integer.parseInt(part.substring(start, end));
                        } else {
                            if (part.charAt(start) == '+') {
                                xCount += 1;
                            } else {
                                xCount -= 1;
                            }
                        }
                    } else {
                        xCount += 1;
                    }
                    start = end + 1;
                } else if (ch == '+' || ch == '-') {
                    if (start < end) {
                        numCount += Integer.parseInt(part.substring(start, end));
                        start = end;
                    }
                }
            }
            if (start < part.length()) {
                numCount += Integer.parseInt(part.substring(start));
            }

            System.out.println(xCount + "-" + numCount);
            return new int[]{xCount, numCount};
        }
    }
}
