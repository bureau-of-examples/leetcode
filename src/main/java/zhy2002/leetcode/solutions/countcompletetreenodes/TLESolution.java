package zhy2002.leetcode.solutions.countcompletetreenodes;

import zhy2002.leetcode.common.TreeNode;

/**
 * Find the height first then count the number of nodes in the last level.
 */
public class TLESolution implements Solution {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int height = 0;
        TreeNode node = root;
        while (node != null){
            height++;
            node = node.left;
        }
        if(height == 1)
            return 1;

        int lastLevelCount = countLastLevelNodes(root, height, 1);

        return (int)Math.pow(2, height - 1) - 1 + lastLevelCount;
    }

    private int countLastLevelNodes(TreeNode node, int height, int level) {
        int count = 0;
        if(level == height - 1){
           if(node.left != null)  {
               count++;
               if(node.right != null) {
                   count++;
               }
           }

           return count;
        }

        level++;
        count += countLastLevelNodes(node.left, height, level);
        if(count > 0)
            count += countLastLevelNodes(node.right, height, level);
        return count;
    }
}
