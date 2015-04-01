package zhy2002.leetcode.solutions.longestvalidparentheses;

import java.util.Stack;

/**
 * Use a stack to store the parentheses - if the neighbouring parentheses form a valid block, then merge them into an Integer.
 * In the end count the largest integer in the stack.
 * A smarter approach is the stack solution.
 */
public class MergeSolution implements Solution {

    @Override
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        //merge valid region
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()) { //')'
                if (stack.peek().equals('(')) {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() instanceof Integer) {
                        stack.push((Integer) stack.pop() + 2);
                    } else {
                        stack.push(2);
                    }
                } else if (stack.peek() instanceof Integer) { //Integer
                    Integer count = (Integer) stack.pop();
                    if (!stack.isEmpty() && stack.peek().equals('(')) {
                        stack.pop();
                        count += 2;
                        if (!stack.isEmpty() && stack.peek() instanceof Integer) {
                            count += (Integer) stack.pop();//2(2)
                        }
                        stack.push(count);
                    } else {
                        stack.push(count);
                        stack.push(')'); //separator
                    }
                }
            }

        }

        //find max
        int maxSize = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() instanceof Integer) {
                Integer count = (Integer) stack.pop();
                if (count > maxSize)
                    maxSize = count;
            } else {
                stack.pop();
            }
        }

        return maxSize;

    }
}
