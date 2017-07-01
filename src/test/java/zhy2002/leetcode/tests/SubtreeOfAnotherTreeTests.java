package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/#/description
 */
public class SubtreeOfAnotherTreeTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null && t == null)
                return true;
            if (s != null && t != null) {
                if (s.val == t.val && match(s.left, t.left) && match(s.right, t.right))
                    return true;

                return isSubtree(s.left, t) || isSubtree(s.right, t);
            } else {
                return false;
            }
        }

        private boolean match(TreeNode s, TreeNode t) {
            if (s == null && t == null)
                return true;
            if (s != null && t != null) {
                return s.val == t.val && match(s.left, t.left) && match(s.right, t.right);
            } else {
                return false;
            }
        }

    }
}
