package zhy2002.leetcode.solutions.binarytreemaximumpathsum;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class Solution {

    private int maxSum;

    public int maxPathSum(TreeNode root) {//assert root != null
        maxSum = Integer.MIN_VALUE;
        findMaxSum(root);
        return maxSum;
    }

    private int findMaxSum(TreeNode parent) {

        int maxPassParent, maxEndAtParent;//maxPassParent -> left subtree - parent - right subtree
        //maxEndAtParent -> left subtree - parent OR parent - right subtree

        if (parent.left == null) {
            if (parent.right == null) {
                maxPassParent = maxEndAtParent = parent.val;
            } else {
                int maxRight = findMaxSum(parent.right);
                maxPassParent = maxEndAtParent = Math.max(parent.val, parent.val + maxRight);
            }
        } else {
            if (parent.right == null) {
                int maxLeft = findMaxSum(parent.left);
                maxPassParent = maxEndAtParent = Math.max(parent.val, parent.val + maxLeft);
            } else {
                int maxLeft = findMaxSum(parent.left);
                int maxRight = findMaxSum(parent.right);
                maxEndAtParent = Math.max(parent.val, Math.max(parent.val + maxLeft, parent.val + maxRight));
                maxPassParent = Math.max(maxEndAtParent, parent.val + maxLeft + maxRight);
            }
        }

        if (maxPassParent > maxSum)
            maxSum = maxPassParent;

        return maxEndAtParent;
    }
}
