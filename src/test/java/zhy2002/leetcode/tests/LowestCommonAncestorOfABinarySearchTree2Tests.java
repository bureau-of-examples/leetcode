package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description
 */
public class LowestCommonAncestorOfABinarySearchTree2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        assertThat(
                solution.lowestCommonAncestor(root, root.right, root),
                sameInstance(root)
        );
    }

    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int diffP = p.val - root.val;
            int diffQ = q.val - root.val;
            if (diffP <= 0 && diffQ >= 0 || diffP >= 0 && diffQ <= 0)
                return root;
            return diffP < 0 ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
        }
    }

}
