package zhy2002.leetcode.solutions.binarytreeupsidedown;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
public class Solution {

    /**
     * Rotate right by 90 degrees.
     * This only works on the type of binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty. I.e.
     *                   *
     *                  /\
     *                 *  *
     *               / \
     *              *   *
     *            / \
     *           *   *
     *         /
     *        *
     * <p/>
     * Where right node:
     * \
     *  *
     *  is optional.
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode oriRoot = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            TreeNode leftLeft = left.left;
            left.left = right;
            TreeNode leftRight = left.right;
            left.right = root;
            root = left;
            left = leftLeft;
            right = leftRight;
        }

        oriRoot.left = null;
        oriRoot.right = null;
        return root;
    }
}
