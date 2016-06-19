package zhy2002.leetcode.solutions.binarytreelongestconsecutivesequence;

import zhy2002.leetcode.common.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * For example,
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class Solution {

    public int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, null, 0);
    }

    private int longestConsecutive(TreeNode node, TreeNode parent, int length) {
        if(node == null)
            return length;

        if(length > 0) {
            if( node.val - 1 == parent.val) {
                length++;
            } else {
                length = 1;
            }
        } else {
            length = 1;
        }
        return Math.max(length, Math.max(longestConsecutive(node.left, node, length), longestConsecutive(node.right, node, length)));
    }
}
