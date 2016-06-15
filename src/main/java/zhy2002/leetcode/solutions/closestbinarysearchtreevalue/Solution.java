package zhy2002.leetcode.solutions.closestbinarysearchtreevalue;

import zhy2002.leetcode.common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class Solution {


    public int closestValue(TreeNode root, double target) {

        return closestValue(root, target, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private Integer closestValue(TreeNode root, double target, double minDiff, double leftBoundary /*inclusive*/, double rightBoundary /*inclusive*/) {
        if (root == null || target < leftBoundary && leftBoundary - target >= minDiff || target > rightBoundary && target - rightBoundary >= minDiff)
            return null;

        Integer closest = null;
        double diff = Math.abs(root.val - target);
        if (diff < minDiff) {
            minDiff = diff;
            closest = root.val;
        }

        Integer leftClosest = closestValue(root.left, target, minDiff, leftBoundary, root.val);
        if (leftClosest != null) {
            int newClosest = leftClosest;
            double newMinDiff = target > newClosest ? target - newClosest : newClosest - target;
            if (newMinDiff < minDiff) {
                minDiff = newMinDiff;
                closest = newClosest;
            }
        }

        Integer rightClosest = closestValue(root.right, target, minDiff, root.val, rightBoundary);
        if (rightClosest != null) {
            int newClosest = rightClosest;
            double newMinDiff = target > newClosest ? target - newClosest : newClosest - target;
            if (newMinDiff < minDiff) {
                closest = newClosest;
            }
        }

        return closest;
    }
}
