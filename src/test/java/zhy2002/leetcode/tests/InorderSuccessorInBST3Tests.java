package zhy2002.leetcode.tests;

import zhy2002.leetcode.common.TreeNode;

import java.util.Stack;

public class InorderSuccessorInBST3Tests {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //access
            if (prev != null && prev.val == p.val) {
                return node;
            }
            prev = node;

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return null;
    }
}
