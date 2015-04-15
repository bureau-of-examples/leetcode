package zhy2002.leetcode.solutions.minimumdepthofbinarytree;

import zhy2002.leetcode.common.TreeNode;

/**
 * Also recursive but slow.
 */
public class SlowSolution implements Solution {

    public int minDepth(TreeNode root) {

        if(root == null)
            return 0;

        int[] buffer = {0x7FFFFFFF, 0};//Integer.MAX_VALUE, 0
        minDepth(buffer, root);//buffer[0] is the global min, buffer[1] is the current recursion depth.
        return buffer[0];


    }

    public void minDepth(int[] buffer, TreeNode root){
        if(root == null)
            return;

        buffer[1]++;
        if(root.left == null && root.right == null){
            if(buffer[0] > buffer[1]){
                buffer[0] = buffer[1];
            }
        } else {
            if(root.left != null){
                minDepth(buffer, root.left);
            }
            if(root.right != null)
            {
                minDepth(buffer, root.right);
            }
        }
        buffer[1]--;
    }
}
