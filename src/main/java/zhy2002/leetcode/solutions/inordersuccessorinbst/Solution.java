package zhy2002.leetcode.solutions.inordersuccessorinbst;

import zhy2002.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        LinkedList<TreeNode> parentPath = getPath(root, p);
        while (!parentPath.isEmpty() && parentPath.peekLast().left != p) {
            p = parentPath.removeLast();
        }
        return parentPath.isEmpty() ? null : parentPath.peekLast();
    }

    private LinkedList<TreeNode> getPath(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> path = new LinkedList<>();
        while (root != p) {
            path.addLast(root);
            if(p.val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return path;
    }
}
