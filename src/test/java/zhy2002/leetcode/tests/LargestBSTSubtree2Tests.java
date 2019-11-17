package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

public class LargestBSTSubtree2Tests {

    @Test
    public void test() {
        System.out.println(largestBSTSubtree(Utils.stringToBinaryTree("10,5,15,1,8,null,7,-1,3")));
        System.out.println(largestBSTSubtree(Utils.stringToBinaryTree("1,2")));
        System.out.println(largestBSTSubtree(Utils.stringToBinaryTree("1,3,2,4,null,null,5")));
    }

    private Integer prev;
    private int start;
    private int maxSize;

    public int largestBSTSubtree(TreeNode root) {
        prev = null;
        start = maxSize = 0;
        inOrder(root, 0);
        return maxSize;
    }

    //returns next index
    private int inOrder(TreeNode root, int nextIndex) {
        if (root == null) {
            return nextIndex;
        }

        int index = inOrder(root.left, nextIndex);
        if (prev != null && prev >= root.val) {
            start = index;
        }
        prev = root.val;
        int ret = inOrder(root.right, ++index);
        if (start <= nextIndex) {
            maxSize = Math.max(maxSize, ret - nextIndex);
        }
        return ret;
    }
}
