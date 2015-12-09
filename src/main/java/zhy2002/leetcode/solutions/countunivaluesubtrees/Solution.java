package zhy2002.leetcode.solutions.countunivaluesubtrees;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/count-univalue-subtrees/
 * Given a binary tree, count the number of uni-value subtrees.
 * <p>
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * For example:
 * Given binary tree,
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * return 4.
 */
public class Solution {

    private int count;

    //solve by recursion: at each node, if it is the root of a UST then count++
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        count = 0;
        isUST(root);
        return count;
    }

    private boolean isUST(TreeNode node){
        if(node.left == null) {
            if(node.right == null){
                count++;
                return true;
            } else {
                if(isUST(node.right) && node.right.val == node.val){
                    count++;
                    return true;
                }
            }
        } else {
            if(node.right == null){
                if(isUST(node.left) && node.left.val == node.val){
                    count++;
                    return true;
                }
            } else {
                if(isUST(node.left) & isUST(node.right) && node.left.val ==  node.right.val && node.left.val == node.val){
                    count++;
                    return true;
                }
            }
        }

        return false;
    }
}
