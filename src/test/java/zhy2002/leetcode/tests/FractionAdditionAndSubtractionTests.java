package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/#/description
 */
public class FractionAdditionAndSubtractionTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.fractionAddition("1/3-1/2"), equalTo("-1/6"));
        assertThat(solution.fractionAddition("-1/2+1/2+1/3"), equalTo("1/3"));
    }

    public class Solution {

        private int index;

        public String fractionAddition(String expression) {
            index = 0;
            int[] current = {0, 1};
            int sign;
            while (index < expression.length()) {
                sign = parseSign(expression);
                int[] next = getNext(expression);
                add(current, sign, next);
            }
            return current[0] + "/" + current[1];
        }

        private void add(int[] current, int sign, int[] next) {
            int top1 = current[0] * next[1];
            int top2 = next[0] * current[1];
            int down1 = current[1] * next[1];
            top1 += sign * top2;
            int d = gcd(Math.abs(top1), down1);
            current[0] = top1 / d;
            current[1] = down1 / d;

        }

        private int gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            }
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            return a;
        }

        private int[] getNext(String expression) {
            int end = index;
            while (end < expression.length() && expression.charAt(end) != '+' && expression.charAt(end) != '-') {
                end++;
            }
            String[] nums = expression.substring(index, end).split("/");
            index = end;
            return new int[]{Integer.parseInt(nums[0]), Integer.parseInt(nums[1])};
        }

        private int parseSign(String expression) {
            int sign = 1;
            while (index < expression.length()) {
                char ch = expression.charAt(index);
                if (ch == '+') {
                    index++;
                } else if (ch == '-') {
                    sign = -sign;
                    index++;
                } else {
                    break;
                }
            }
            return sign;
        }
    }
}
