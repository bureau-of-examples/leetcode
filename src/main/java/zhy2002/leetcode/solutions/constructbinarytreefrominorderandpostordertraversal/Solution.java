package zhy2002.leetcode.solutions.constructbinarytreefrominorderandpostordertraversal;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public interface Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder);
}
