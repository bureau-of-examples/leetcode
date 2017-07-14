package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description
 */
public class LowestCommonAncestorOfABinaryTree2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = Utils.stringToBinaryTree("3");
        TreeNode result = solution.lowestCommonAncestor(root, root, root);
        assertThat(result.val, equalTo(3));

        root = Utils.stringToBinaryTree("3,null,2");
        result = solution.lowestCommonAncestor(root, root, root.right);
        assertThat(result.val, equalTo(3));

        root.left = new TreeNode(1);
        result = solution.lowestCommonAncestor(root, root.left, root.right);
        assertThat(result.val, equalTo(3));

        root.left.left = new TreeNode(10);
        result = solution.lowestCommonAncestor(root, root.left.left, root.left);
        assertThat(result.val, equalTo(1));

        result = solution.lowestCommonAncestor(root, root.left.left, root.right);
        assertThat(result.val, equalTo(3));
    }

    public class Solution {

        private TreeNode result;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            result = null;
            search(root, p, q);
            return result;
        }

        private TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || result != null)
                return null;

            TreeNode left = search(root.left, p, q);
            TreeNode right = search(root.right, p, q);
            if (result != null)
                return null;

            if (left != null && right != null) {
                result = root;
                return null;
            }

            if ((root == p || root == q)) {
                if (left != null || right != null) {
                    result = root;
                    return null;
                } else {
                    if (root == p && root == q) {
                        result = root;
                    }
                    return root;
                }
            }

            return left == null ? right : left;
        }
    }
}
