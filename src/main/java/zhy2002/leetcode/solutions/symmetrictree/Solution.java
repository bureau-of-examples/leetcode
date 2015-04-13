package zhy2002.leetcode.solutions.symmetrictree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problemset/algorithms/
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isMirror(root.left, root.right);

    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null) {
            if (right == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (right == null) {
                return false;
            } else {
                if (left.val != right.val)
                    return false;

                if (!isMirror(left.left, right.right))
                    return false;

                return isMirror(left.right, right.left);
            }
        }
    }

}
