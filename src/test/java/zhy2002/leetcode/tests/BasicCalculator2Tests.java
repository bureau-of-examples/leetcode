package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/basic-calculator/#/description
 * https://leetcode.com/problems/basic-calculator-ii/#/description
 */
public class BasicCalculator2Tests {

    @Test
    public void test() {
        Solution calculator = new Solution();
        assertThat(calculator.calculate("-5 + 3"), equalTo(-2));
        assertThat(calculator.calculate("-5 + 3*4"), equalTo(7));
        assertThat(calculator.calculate("(1+(4+5+2)-3)+(6+8)"), equalTo(23));
        assertThat(calculator.calculate("(1+2)*5"), equalTo(15));
        assertThat(calculator.calculate("(1+2*5)"), equalTo(11));
        assertThat(calculator.calculate("(1+1)"), equalTo(2));
    }

    public class Solution {
        private int index;
        private Stack<Integer> valueStack = new Stack<>();
        private Stack<Character> opStack = new Stack<>();

        public int calculate(String expr) {
            index = 0;
            valueStack.clear();
            opStack.clear();

            boolean expectingValue = true;
            while (index < expr.length()) {
                char ch = expr.charAt(index);
                if (ch == ' ') {
                    index++;
                    continue;
                }
                if (expectingValue) {
                    if (ch == '(') {
                        opStack.push(ch);
                        index++;
                        continue;
                    }
                    int value = parseValue(expr);
                    valueStack.push(value);
                    expectingValue = false;
                } else {
                    reduce(ch);
                    index++;
                    if (ch == ')') {
                        if (opStack.pop() != '(')
                            throw new RuntimeException("Parentheses mismatch at " + index);
                    } else {
                        expectingValue = true;
                    }
                }
            }
            if (!opStack.isEmpty()) {
                reduce(')');
            }
            return valueStack.pop();
        }

        private int parseValue(String expr) {
            int end = index;
            while (end < expr.length() && !Character.isDigit(expr.charAt(end))) {
                end++;
            }
            while (end < expr.length() && (Character.isDigit(expr.charAt(end)) || expr.charAt(end) == '.')) {
                end++;
            }
            int value = Integer.parseInt(expr.substring(index, end));
            index = end;
            return value;
        }

        private void reduce(char op) {
            while (!opStack.isEmpty() && opStack.peek() != '(' && priority(opStack.peek()) >= priority(op)) {
                int right = valueStack.pop();
                int left = valueStack.pop();
                int value = compute(opStack.pop(), left, right);
                valueStack.push(value);
            }
            if (op != ')') {
                opStack.push(op);
            }
        }

        private int compute(char op, int left, int right) {
            switch (op) {
                case '+':
                    return left + right;
                case '-':
                    return left - right;
                case '*':
                    return left * right;
                case '/':
                    return left / right;
            }
            throw new RuntimeException("unknown operator: " + op);
        }

        private int priority(char op) {
            if (op == '+' || op == '-')
                return 1;
            if (op == '*' || op == '/')
                return 2;
            if (op == ')')
                return 0;
            throw new RuntimeException("unknown operator: " + op);
        }
    }

}
