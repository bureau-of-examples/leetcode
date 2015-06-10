package zhy2002.leetcode.solutions.countcompletetreenodes;

import zhy2002.leetcode.common.TreeNode;

/**
 * Solution come from:
 * https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
 */
public class DnCSolution implements Solution {

    int height(TreeNode root) {//calculate the normal height-1
        int height = 0;
        while (root != null){
            height++;
            root = root.left;
        }

        return height - 1;
    }

    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);

        while (root != null) {
            int childMaxHeight = h - 1;
            if (height(root.right) == childMaxHeight) {//left child is full
                nodes += 1 << h; //number of nodes in root + left sub-tree
                root = root.right;
            } else {
                nodes += 1 << childMaxHeight;//number of nodes in root + right sub-tree; right sub-tree is one level less
                root = root.left;
            }
            h = childMaxHeight;
        }
        return nodes;
    }
}
