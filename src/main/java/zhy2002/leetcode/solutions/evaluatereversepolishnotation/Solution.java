package zhy2002.leetcode.solutions.evaluatereversepolishnotation;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> evalStack = new Stack<>();
        for (String token : tokens) {
            Integer leftOp = null, rightOp = null;
            if ("+-*/".contains(token) && token.length() == 1) {
                rightOp = evalStack.pop();
                leftOp = evalStack.pop();
            }
            switch (token) {
                case "+":
                    evalStack.push(leftOp + rightOp);
                    break;
                case "-":
                    evalStack.push(leftOp - rightOp);
                    break;
                case "*":
                    evalStack.push(leftOp * rightOp);
                    break;
                case "/":
                    evalStack.push(leftOp / rightOp);
                    break;
                default:
                    evalStack.push(Integer.parseInt(token));
                    break;
            }
        }
        int result = evalStack.pop();
        if (!evalStack.isEmpty())
            throw new RuntimeException();
        return result;
    }

}
