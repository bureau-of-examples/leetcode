package zhy2002.leetcode.solutions.lowestcommonancestorofabinarysearchtree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */
public class Solution {

    //assume there is no duplicate nodes
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;

        if(q.val < p.val){
            TreeNode temp = q;
            q = p;
            p = temp;
        }

        while (true){
            if(ancestor.val >= p.val && ancestor.val <= q.val){
                break;
            }

            if(ancestor.val < p.val){
                ancestor = ancestor.right;
            } else {
                ancestor = ancestor.left;
            }
        }

        return ancestor;
    }
}
