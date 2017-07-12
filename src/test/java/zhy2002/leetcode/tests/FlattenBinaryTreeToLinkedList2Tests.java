package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/#/description
 */
public class FlattenBinaryTreeToLinkedList2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = Utils.stringToBinaryTree("6,5,4");
        solution.flatten(root);
        assertThat(
                Utils.binaryTreeToString(root),
                equalTo("6 # 5 # 4")
        );
    }

    public class Solution {
        public void flatten(TreeNode root) {
            solve(root);
        }

        private TreeNode solve(TreeNode node) {
            if (node == null)
                return null;

            TreeNode left = node.left;
            TreeNode leftEnd = solve(left);
            TreeNode right = node.right;
            TreeNode rightEnd = solve(right);
            node.left = null;
            node.right = left;
            if (leftEnd == null) {
                node.right = right;
            } else {
                leftEnd.right = right;
            }
            return rightEnd == null ? leftEnd == null ? node : leftEnd : rightEnd;
        }
    }
}
