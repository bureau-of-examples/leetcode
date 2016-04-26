package zhy2002.leetcode.solutions.largestbstsubtree;

import zhy2002.leetcode.common.TreeNode;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 * A subtree must include all of its descendants.
 * Here's an example:
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * The Largest BST Subtree in this case is rooted at 5.
 */
public class Solution {

    private class CountingStatus {
        private int nodeCount;
        private int minValue;
        private int maxValue;
    }

    private int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        maxSize = 0;
        count(root);
        return maxSize;
    }

    private CountingStatus count(TreeNode root) {
        if (root == null)
            return null;

        CountingStatus status = new CountingStatus();
        status.nodeCount = 1;
        status.minValue = status.maxValue = root.val;
        CountingStatus leftStatus = count(root.left);
        CountingStatus rightStatus = count(root.right);

        if (leftStatus != null) {
            if(leftStatus.nodeCount == 0 || root.val < leftStatus.maxValue) { //not a valid bst
                status.nodeCount = 0;
                return status;
            }
            status.nodeCount += leftStatus.nodeCount;
            status.minValue = Math.min(status.minValue, leftStatus.minValue);
        }

        if (rightStatus != null) {
            if(rightStatus.nodeCount == 0 || root.val > rightStatus.minValue) {
                status.nodeCount = 0;
                return status;
            }
            status.nodeCount += rightStatus.nodeCount;
            status.maxValue = Math.max(status.maxValue, rightStatus.maxValue);
        }

        maxSize = Math.max(maxSize, status.nodeCount);
        return status;
    }
}
