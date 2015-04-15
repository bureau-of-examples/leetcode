package zhy2002.leetcode.solutions.constructbinarytreefrominorderandpostordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * HashMap solution.
 */
public class HashMapSolution implements Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }
        int end = postorder.length - 1;
        return buildTreePost(inOrderIndex, postorder, 0, end, end);
    }

    private static TreeNode buildTreePost(HashMap<Integer, Integer> inOrderIndex, int[] postOrder, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postOrder[rootIndex]);
        int index = inOrderIndex.get(root.val);
        int rightSize = inEnd - index;

        root.left = buildTreePost(inOrderIndex, postOrder, inStart, index - 1, rootIndex - rightSize - 1);
        root.right = buildTreePost(inOrderIndex, postOrder, index + 1, inEnd, rootIndex - 1);
        return root;
    }

}
