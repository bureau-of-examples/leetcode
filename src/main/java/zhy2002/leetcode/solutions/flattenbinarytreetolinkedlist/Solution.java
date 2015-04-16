package zhy2002.leetcode.solutions.flattenbinarytreetolinkedlist;

import zhy2002.leetcode.common.TreeNode;


/**
 * https://leetcode.com/problemset/algorithms/
 */
public class Solution {

    public void flatten(TreeNode root) {
        flattenRecursive(root);
    }

    public static TreeNode flattenRecursive(TreeNode root) {
        if (root == null)
            return null;

        TreeNode leftEnd = null;
        if (root.left != null) {
            leftEnd = flattenRecursive(root.left);
        }

        TreeNode rightEnd = null;
        if (root.right != null) {
            rightEnd = flattenRecursive(root.right);
        }

        if (leftEnd != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            leftEnd.right = right;
        }
        return rightEnd != null ? rightEnd : (leftEnd != null ? leftEnd : root);
    }
}
