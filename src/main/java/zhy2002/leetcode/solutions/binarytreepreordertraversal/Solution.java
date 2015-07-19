package zhy2002.leetcode.solutions.binarytreepreordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class Solution {

    /**
     * Use a stack, and access a value when a node is popped from the stack.
     * Push the root in.
     * pop the root and push right node and left node.
     * Then keep popping node and pushing children until the stack becomes empty.
     *
     * @param root root of the binary tree.
     * @return preorder values of the binary tree.
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        java.util.Stack<TreeNode> nodes = new java.util.Stack<>();
        java.util.ArrayList<Integer> result = new java.util.ArrayList<>();

        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node == null)
                continue;

            result.add(node.val);
            nodes.push(node.right);
            nodes.push(node.left);
        }
        return result;
    }
}
