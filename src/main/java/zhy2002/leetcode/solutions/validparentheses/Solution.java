package zhy2002.leetcode.solutions.validparentheses;

import java.util.Stack;

/**
 *https://leetcode.com/problems/valid-parentheses/
 * Use stack.
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("([{".indexOf(ch) >= 0) {
                stack.push(ch);
            } else if ("}])".indexOf(ch) >= 0) {
                if (stack.isEmpty())
                    return false;
                char stored = stack.pop();
                if (ch == '}' && stored != '{')
                    return false;
                if (ch == ']' && stored != '[')
                    return false;
                if (ch == ')' && stored != '(')
                    return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
