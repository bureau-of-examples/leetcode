package zhy2002.leetcode.solutions.convertsortedarraytobinarysearchtree;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Recursion.
 */
public class Solution {


    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null)
            return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
}
