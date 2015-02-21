package zhy2002.leetcode.solutions.binarysearchtreeiterator;

import zhy2002.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {

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