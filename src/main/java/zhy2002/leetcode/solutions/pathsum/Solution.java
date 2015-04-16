package zhy2002.leetcode.solutions.pathsum;

import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        int childSum = sum - root.val;
        if(root.left == null && root.right == null && childSum == 0)
            return true;

        if(hasPathSum(root.left, childSum))
            return true;
        if(hasPathSum(root.right, childSum))
            return true;

        return false;
    }
}
