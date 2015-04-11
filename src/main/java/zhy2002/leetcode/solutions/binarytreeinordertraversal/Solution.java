package zhy2002.leetcode.solutions.binarytreeinordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        java.util.ArrayList<Integer> result = new java.util.ArrayList<>();

        if (root == null)
            return result;

        java.util.Stack<TreeNode> nodes = new java.util.Stack<>();
        nodes.push(root);
        TreeNode currentLeft = root.left;

        while (!nodes.isEmpty()) {
            if (currentLeft == null) {
                TreeNode node = nodes.pop();
                result.add(node.val);
                if (node.right != null) {
                    nodes.push(node.right);
                    currentLeft = node.right.left;
                }
            } else {
                nodes.push(currentLeft);
                currentLeft = currentLeft.left;
            }
        }

        return result;
    }
}
