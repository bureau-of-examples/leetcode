package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreemaximumpathsum.Solution;

import static org.junit.Assert.*;

public class BinaryTreeMaximumPathSumTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-1);
        root.right = new TreeNode(1);
        assertEquals(4, solution.maxPathSum(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        assertEquals(10, solution.maxPathSum(root));

        root.left.left.left = new TreeNode(-4);
        assertEquals(6, solution.maxPathSum(root));
    }
}
