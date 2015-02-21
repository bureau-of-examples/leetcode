package zhy2002.leetcode.solutions.sametree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://oj.leetcode.com/problems/same-tree/
 * p and q are the same tree <=> p.val == q.val && p.left and q.left are the same tree && p.right and q.right are the same tree.
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else {
            if (q == null) {
                return false;
            } else {
                if (p.val != q.val)
                    return false;

                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
