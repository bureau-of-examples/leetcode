package zhy2002.leetcode.solutions.balancedbinarytree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {

        return getHeight(root) != -1;//-1 if unbalanced.
    }

    private static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        if (left == -1)
            return -1;

        int right = getHeight(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

}
