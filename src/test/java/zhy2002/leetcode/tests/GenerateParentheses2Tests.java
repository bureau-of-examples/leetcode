package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class GenerateParentheses2Tests {

    @Test
    public void test() {
       Solution solution = new Solution();
       List<String> result = solution.generateParenthesis(4);
       assertThat(Utils.listToString(result), equalTo("(((()))) ((()())) ((())()) ((()))() (()(())) (()()()) (()())() (())(()) (())()() ()((())) ()(()()) ()(())() ()()(()) ()()()()"));
    }

    class Solution {
        private List<String> result;

        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            solve(new StringBuilder(), 0, 0, n);
            return result;
        }

        private void solve(StringBuilder sb, int leftCount, int rightCount, int n) {
            if (leftCount == n && rightCount == n) {
                result.add(sb.toString());
                return;
            }

            if (leftCount < n) {
                sb.append("(");
                solve(sb, leftCount + 1, rightCount, n);
                sb.setLength(sb.length() - 1);
            }
            if (rightCount < leftCount) {
                sb.append(")");
                solve(sb, leftCount, rightCount + 1, n);
                sb.setLength(sb.length() - 1);
            }
        }
    }

}
