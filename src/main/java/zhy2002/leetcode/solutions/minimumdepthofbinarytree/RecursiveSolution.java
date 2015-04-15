package zhy2002.leetcode.solutions.minimumdepthofbinarytree;

import zhy2002.leetcode.common.TreeNode;

/**
 * Recursion.
 */
public class RecursiveSolution implements Solution{

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        int lMin = minDepth(root.left);
        int rMin = minDepth(root.right);

        if (lMin == 0) {
            if (rMin == 0) {
                return 1;
            } else {
                return rMin + 1;
            }
        } else {
            if (rMin == 0) {
                return lMin + 1;
            } else {
                return Math.min(lMin, rMin) + 1;
            }
        }

    }
}
