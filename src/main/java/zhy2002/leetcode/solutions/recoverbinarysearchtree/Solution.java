package zhy2002.leetcode.solutions.recoverbinarysearchtree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 */
public class Solution {

    private TreeNode previous;
    private TreeNode first;
    private TreeNode firstNext;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        previous  = first = second = null;

        traversal(root);

        if(second == null)
            second = firstNext;
        if (first != null && second != null) {
            int firstVal = first.val;
            first.val = second.val;
            second.val = firstVal;
        }
    }

    private boolean traversal(TreeNode parent) {
        if (parent == null)
            return true;

        if (!traversal(parent.left))
            return false;

        if (previous != null && previous.val > parent.val) {
            if (first == null) {
                first = previous;
                firstNext = parent;
            } else if (second == null) {
                second = parent;
            } else {
                return false; //got two already
            }
        }
        previous = parent;

        return traversal(parent.right);
    }
}
