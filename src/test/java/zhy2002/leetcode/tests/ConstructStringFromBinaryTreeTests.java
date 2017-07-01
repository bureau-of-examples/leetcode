package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;


public class ConstructStringFromBinaryTreeTests {

    @Test
    public void test() {}

    private static class Solution {
        public String tree2str(TreeNode t) {
            StringBuilder stringBuilder = new StringBuilder();
            solve(stringBuilder, t);
            return stringBuilder.toString();
        }

        private void solve(StringBuilder stringBuilder, TreeNode t) {
            if (t == null)
                return;

            stringBuilder.append(t.val);
            if (t.right != null || t.left != null) {
                stringBuilder.append("(");
                solve(stringBuilder, t.left);
                stringBuilder.append(")");
            }
            if (t.right != null) {
                stringBuilder.append("(");
                solve(stringBuilder, t.right);
                stringBuilder.append(")");
            }
        }
    }
}
