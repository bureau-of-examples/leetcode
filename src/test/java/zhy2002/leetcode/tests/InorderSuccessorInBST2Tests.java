package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/#/description
 */
public class InorderSuccessorInBST2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        assertThat(solution.inorderSuccessor(root, root), nullValue());
        root.right = new TreeNode(2);
        assertThat(solution.inorderSuccessor(root, root), sameInstance(root.right));
        root.right.left = new TreeNode(3);
        assertThat(solution.inorderSuccessor(root, root), sameInstance(root.right.left));
        root.left = new TreeNode(4);
        assertThat(solution.inorderSuccessor(root, root.left), sameInstance(root));
        root.left.left = new TreeNode(5);
        assertThat(solution.inorderSuccessor(root, root.left.left), sameInstance(root.left));
    }

    public class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (p.right != null) {
                return leftMost(p.right);
            }
            result = null;
            firstLeftParent(root, p);
            return result;
        }

        private TreeNode result;

        private boolean firstLeftParent(TreeNode node, TreeNode p) {
            if (node == null)
                return false;
            if (node == p)
                return true;
            boolean covers = firstLeftParent(node.left, p);
            if (covers && result == null) {
                result = node;
            }
            return firstLeftParent(node.right, p);
        }

        private TreeNode leftMost(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

}
