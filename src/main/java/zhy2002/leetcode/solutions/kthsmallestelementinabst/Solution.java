package zhy2002.leetcode.solutions.kthsmallestelementinabst;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);

        if(count >= k)
            return kthSmallest(root.left, k);
        if(count == k - 1)
            return root.val;

        return kthSmallest(root.right, k - count - 1);

    }

    private int count(TreeNode node){
        if(node == null)
            return 0;
        return count(node.left) + 1 + count(node.right);
    }
}
