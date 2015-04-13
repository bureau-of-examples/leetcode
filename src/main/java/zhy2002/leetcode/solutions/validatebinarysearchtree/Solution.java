package zhy2002.leetcode.solutions.validatebinarysearchtree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, int min, int max) {
        if (root != null) {
            if (root.val < min || root.val > max)
                return false;

            if (root.left != null) {
                if (root.val == Integer.MIN_VALUE || !isValidBST(root.left, min, root.val - 1))
                    return false;
            }

            if (root.right != null) {
                if (root.val == Integer.MAX_VALUE || !isValidBST(root.right, root.val + 1, max))
                    return false;
            }
        }

        return true;
    }

}
