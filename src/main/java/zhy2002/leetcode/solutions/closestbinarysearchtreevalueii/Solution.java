package zhy2002.leetcode.solutions.closestbinarysearchtreevalueii;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jzhang on 15/06/2016.
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * <p>
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * <p>
 * Hint:
 * <p>
 * Consider implement these two helper functions:
 * getPredecessor(N), which returns the next smaller node to N.
 * getSuccessor(N), which returns the next larger node to N.
 * Try to assume that each node has a parent pointer, it makes the problem much easier.
 * Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        LinkedList<TreeNode> path = new LinkedList<>();
        findClosest(path, root, target);
        return findKClosest(path, k, target);
    }

    private void findClosest(LinkedList<TreeNode> path, TreeNode root, double target) {

        TreeNode closest = null;
        do {
            if (closest == null || Math.abs(target - closest.val) > Math.abs(target - root.val)) {
                closest = root;
            }
            path.addLast(root);
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        } while (root != null);

        while (path.peekLast() != closest) {
            path.removeLast();
        }
    }

    private List<Integer> findKClosest(LinkedList<TreeNode> path, int k, double target) {
        List<Integer> result = new ArrayList<>();
        if (k <= 0)
            return result;

        TreeNode node = path.peekLast();
        result.add(node.val);
        if (k == 1)
            return result;

        LinkedList<TreeNode> leftPath = path;
        LinkedList<TreeNode> rightPath = new LinkedList<>(path);
        moveToPrevious(leftPath);
        moveToNext(rightPath);
        while (--k > 0) {

            boolean moveLeft;
            if(leftPath.isEmpty()) {
                moveLeft = false;
            } else {
                if(rightPath.isEmpty()) {
                    moveLeft = true;
                } else {
                    moveLeft = Math.abs(target - leftPath.peekLast().val) < Math.abs(target - rightPath.peekLast().val);
                }
            }

            if (moveLeft) {
                result.add(leftPath.peekLast().val);
                moveToPrevious(leftPath);
            } else {
                result.add(rightPath.peekLast().val);
                moveToNext(rightPath);
            }
        }
        return result;
    }

    private void moveToNext(LinkedList<TreeNode> rightPath) {
        TreeNode node = rightPath.peekLast().right;
        if(node == null) {
            do {
                node = rightPath.removeLast();
            } while (!rightPath.isEmpty() && node == rightPath.peekLast().right);
            return;
        }

        do {
            rightPath.addLast(node);
            node = node.left;
        } while (node != null);
    }

    private void moveToPrevious(LinkedList<TreeNode> leftPath) {

        TreeNode node = leftPath.peekLast().left;
        if (node == null) {
            do {
                node = leftPath.removeLast();
            } while (!leftPath.isEmpty() && node == leftPath.peekLast().left);
            return;
        }
        do {
            leftPath.addLast(node);
            node = node.right;
        } while (node != null);
    }
}