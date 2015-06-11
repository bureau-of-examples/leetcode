package zhy2002.leetcode.solutions.basiccalculator;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 */
public class Solution {

    private static final HashMap<Character, Integer> OP_PRIORITIES = new HashMap<>();

    static {
        OP_PRIORITIES.put('+', 100);
        OP_PRIORITIES.put('-', 100);
        OP_PRIORITIES.put('*', 200);
        OP_PRIORITIES.put('/', 200);
        OP_PRIORITIES.put('(', Integer.MAX_VALUE);
    }

    private final Stack<Integer> valueStack = new Stack<>();
    private final Stack<Character> opStack = new Stack<>();


    public int calculate(String s) {
        valueStack.clear();
        opStack.clear();
        boolean lastIsValue = false;
        int index = 0;
        while (index <= s.length()) {
            char ch = index < s.length() ? s.charAt(index++) : '#';
            if (ch == ' ')
                continue;

            boolean sign = true;
            if (!lastIsValue && ch == '-') {
                sign = false;
                while (index <= s.length()) {
                  if(index == s.length())
                      throw new RuntimeException("Incomplete negative number");
                    ch = s.charAt(index++);
                    if(ch == ' ')
                        continue;
                    if(ch == '-')
                        sign = !sign;
                    else if(ch >= '0' && ch <= '9')
                        break;
                    else
                        throw new RuntimeException("Invalid negative number");
                }
            }

            if (ch == '(') {
                opStack.push(ch);
                lastIsValue = false;

            } else if (OP_PRIORITIES.containsKey(ch)) {
                evaluate(OP_PRIORITIES.get(ch));
                opStack.push(ch);
                lastIsValue = false;

            } else if (ch >= '0' && ch <= '9') {
                int startIndex = index - 1;
                while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9')
                    index++;
                valueStack.push(Integer.valueOf((sign ? "" : "-") + s.substring(startIndex, index)));
                lastIsValue = true;

            } else if (ch == ')') {
                evaluate(0);
                if (opStack.peek() == '(')
                    opStack.pop();
                else
                    throw new RuntimeException("Parenthesis mismatch");
                lastIsValue = true;
            } else if (ch == '#') {
                evaluate(0);
                break;
            } else {
                throw new RuntimeException("Unknown character '" + ch + "'");
            }
        }
        return valueStack.pop();
    }

    private void evaluate(int priority) {
        while (!opStack.isEmpty() && opStack.peek() != '(' && OP_PRIORITIES.get(opStack.peek()) >= priority) {
            char op = opStack.pop();
            int value2 = valueStack.pop();
            int value1 = valueStack.pop();

            if (op == '+') {
                value1 += value2;
            } else if (op == '-') {
                value1 -= value2;
            } else if (op == '*') {
                value1 *= value2;
            } else if (op == '/') {
                value1 /= value2;
            }

            valueStack.push(value1);
        }
    }
}
