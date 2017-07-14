package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/#/description
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(new int[]{1}, new int[]{1});
        assertThat(Utils.binaryTreeToString(root), equalTo("1"));

        root = solution.buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
        assertThat(Utils.binaryTreeToString(root), equalTo("1 2 3"));

        root = solution.buildTree(new int[]{1, 3, 2}, new int[]{3, 1, 2});
        assertThat(Utils.binaryTreeToString(root), equalTo("1 3 2"));

        root = solution.buildTree(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        assertThat(Utils.binaryTreeToString(root), equalTo("1 # 2 3"));
    }

    public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0)
                return null;

            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) { //look up index in inorder quickly
                indexMap.put(inorder[i], i);
            }

            return build(preorder, inorder, indexMap, 0, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int[] inorder, Map<Integer, Integer> indexMap, int preorderIndex, int inorderStart, int inorderEnd) {
            TreeNode node = new TreeNode(preorder[preorderIndex]);
            int inorderIndex = indexMap.get(node.val);
            int inorderLeftEnd = inorderIndex - 1;
            if (inorderStart <= inorderLeftEnd) { //has left
                node.left = build(preorder, inorder, indexMap, preorderIndex + 1, inorderStart, inorderLeftEnd);
            }
            int inorderRightStart = inorderIndex + 1;
            if (inorderRightStart <= inorderEnd) {
                int leftSize = inorderLeftEnd - inorderStart + 1;
                node.right = build(preorder, inorder, indexMap, preorderIndex + leftSize + 1, inorderRightStart, inorderEnd);
            }
            return node;
        }
    }
}
