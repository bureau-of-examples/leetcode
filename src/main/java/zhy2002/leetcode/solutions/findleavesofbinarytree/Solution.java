package zhy2002.leetcode.solutions.findleavesofbinarytree;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
 */
public class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        findIndex(results, root);
        return results;
    }

    private int findIndex(List<List<Integer>> results, TreeNode root) {
        if (root == null)
            return -1;
        int leftIndex = findIndex(results, root.left);
        int rightIndex = findIndex(results, root.right);
        int index = Math.max(leftIndex, rightIndex) + 1;
        while (index >= results.size())
            results.add(new ArrayList<>());
        results.get(index).add(root.val);
        return index;
    }
}
