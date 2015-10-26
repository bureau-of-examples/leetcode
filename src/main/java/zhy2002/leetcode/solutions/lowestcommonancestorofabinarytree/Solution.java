package zhy2002.leetcode.solutions.lowestcommonancestorofabinarytree;

import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //assume the arguments are not null
        TreeNode other = null;

        //find one of p and q, and assign the other to other variable
        Stack<TreeNode> path = new Stack<>();
        path.push(root);
        HashMap<TreeNode, Integer> accessFlag = new HashMap<>(); //not expanded, left pushed, right pushed
        while (!path.isEmpty()){
            TreeNode node = path.peek();
            if(node == null){
                path.pop();
                continue;
            }
            if(node == p) {
                other = q;
                break;
            } else if(node == q){
                other = p;
                break;
            }

            Integer flag = accessFlag.get(node);
            if(flag == null){
                path.push(node.left);
                accessFlag.put(node, 1);
            } else if(flag == 1){
                path.push(node.right);
                accessFlag.put(node, 2);
            } else {
                path.pop();
                accessFlag.remove(node);
            }
        }

        //cannot find any of p and q in tree
        if(other == null)
            return null;

        //check which one in path is an ancestor of other
        while (!path.isEmpty()) {
            TreeNode node = path.pop();
            if(contains(node, other, accessFlag)){
                return node;
            }
        }

        return null;
    }

    private boolean contains(TreeNode node, TreeNode other, HashMap<TreeNode, Integer> accessFlag) {
        if(node == other){
            return true;
        }
        Integer flag = accessFlag == null ? null : accessFlag.get(node);
        if(flag == null){
            if(node.left != null && contains(node.left, other, null))
                return true;
        }

        if(flag == null || flag == 1){
            if(node.right != null && contains(node.right, other, null))
                return true;
        }
        return false;
    }
}
