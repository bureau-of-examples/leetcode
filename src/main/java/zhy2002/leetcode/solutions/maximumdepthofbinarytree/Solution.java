package zhy2002.leetcode.solutions.maximumdepthofbinarytree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
}
