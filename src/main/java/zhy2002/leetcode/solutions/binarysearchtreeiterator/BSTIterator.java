package zhy2002.leetcode.solutions.binarysearchtreeiterator;

import zhy2002.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {

    //use a stack to help with in-order traversal.
    private Stack<TreeNode> notVisited = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null){
            notVisited.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !notVisited.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode visit = notVisited.pop();
        TreeNode node = visit.right;
        while (node != null){
            notVisited.add(node);
            node = node.left;
        }
        return visit.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */