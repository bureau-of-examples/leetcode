package zhy2002.leetcode.solutions.longestvalidparentheses;

import java.util.Stack;

/**
 * Use a stack to store increasing indices of s. matched symbols are popped so the size of valid block is represented by the gap of the indices in the stack.
 */
public class StackSolution implements Solution {

    @Override
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')' && !stack.isEmpty() && arr[stack.peek()] == '(') {
                stack.pop();
                if (stack.isEmpty())
                    res = i + 1;
                else
                    res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }



}
