package zhy2002.leetcode.solutions.constructbinarytreefrompreorderandinordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        return buildTree(inOrderIndex, preorder, 0, inorder.length - 1, 0);
    }

    private static TreeNode buildTree(HashMap<Integer, Integer> inOrderIndex, int[] preOrder, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int index = inOrderIndex.get(root.val);
        int leftSize = index - inStart;
        root.left = buildTree(inOrderIndex, preOrder, inStart, index - 1, rootIndex + 1);
        root.right = buildTree(inOrderIndex, preOrder, index + 1, inEnd, rootIndex + leftSize + 1);
        return root;
    }
}
