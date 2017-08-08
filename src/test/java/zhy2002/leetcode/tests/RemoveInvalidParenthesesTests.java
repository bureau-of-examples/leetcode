package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 */
public class RemoveInvalidParenthesesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        for (String s : solution.removeInvalidParentheses("()(((((((()")) {
            System.out.println(">>>" + s);
        }
    }

    public class Solution {
        private Set<String> result;

        public List<String> removeInvalidParentheses(String s) {
            result = new HashSet<>();
            bfs(s);
            return new ArrayList<>(result);
        }

        private boolean isValid(String s) {
            int openCount = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    openCount++;
                } else if (ch == ')') {
                    openCount--;
                    if (openCount < 0)
                        return false;
                }
            }
            return openCount == 0;
        }

        private void bfs(String s) {
            Deque<String> deque = new LinkedList<>();
            Set<String> enqueued = new HashSet<>();
            deque.add(s);
            enqueued.add(s);
            boolean existOnNull = false;
            while (!deque.isEmpty()) {
                String val = deque.poll();
                if (val == null) {
                    if (existOnNull)
                        break;
                    else {
                        deque.add(null);
                        continue;
                    }
                }
                if (isValid(val)) {
                    existOnNull = true;
                    result.add(val);
                }
                if (existOnNull)
                    continue;
                for (int i = 0; i < val.length(); i++) {
                    if (val.charAt(i) == '(' || val.charAt(i) == ')') {
                        String next = val.substring(0, i) + val.substring(i + 1);
                        if (!enqueued.contains(next)) {
                            deque.add(next);
                            enqueued.add(next);
                        }
                    }
                }
            }
        }
    }

}
