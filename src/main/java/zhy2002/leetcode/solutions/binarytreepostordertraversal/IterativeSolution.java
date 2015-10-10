package zhy2002.leetcode.solutions.binarytreepostordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Solve iteratively with a stack.
 */
public class IterativeSolution implements Solution {

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        java.util.Stack<TreeNode> unexpanded = new java.util.Stack<>();//stack of nodes not visited yet
        java.util.Set<TreeNode> expanded = new HashSet<>(); //if the children of a node is added to the stack

        unexpanded.push(root);

        while (!unexpanded.isEmpty()) {
            TreeNode node = unexpanded.peek();
            if (expanded.contains(node)) {
                result.add(node.val); //access
                unexpanded.pop();
                expanded.remove(node);
            } else {
                if (node.right != null)
                    unexpanded.push(node.right);
                if (node.left != null)
                    unexpanded.push(node.left);
                expanded.add(node);
            }
        }
        return result;
    }
}
