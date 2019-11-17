package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

public class CountCompleteTreeNodes2Tests {

    @Test
    public void test() {
        System.out.println(countNodes(Utils.stringToBinaryTree("1")));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = leftMostDepth(root);
        int parentCount = (int)Math.pow(2, depth - 1) - 1;
        return parentCount + leafCount(root, depth);
    }

    private int leafCount(TreeNode node, int depth) {
        int count = 0;
        int curDepth = 1;
        while(node != null) {
            int d = rightMostDepth(node.left);
            if (d + curDepth == depth) {
                count += d == 0 ? 1 : (int)Math.pow(2, d - 1);
                node = node.right;
            } else {
                node = node.left;
            }
            curDepth++;
        }
        return count;
    }

    private int rightMostDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }

    private int leftMostDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

}
