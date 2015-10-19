package zhy2002.leetcode.solutions.invertbinarytree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Given a binary tree, recursively swap left and right subtree.
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {

         if(root == null)
             return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
