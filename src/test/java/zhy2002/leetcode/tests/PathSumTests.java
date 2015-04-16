package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.pathsum.Solution;

import static org.junit.Assert.*;

public class PathSumTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        assertEquals(true,solution.hasPathSum(root, 1));
        assertEquals(false,solution.hasPathSum(root, 2));
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals(true,solution.hasPathSum(root, 3));
        assertEquals(true,solution.hasPathSum(root, 4));
        assertEquals(false,solution.hasPathSum(root, 5));
        root.left.left = new TreeNode(1);
        assertEquals(true,solution.hasPathSum(root, 4));
        root.left.left.right = new TreeNode(99);
        assertEquals(false,solution.hasPathSum(root,108));
        assertEquals(false,solution.hasPathSum(root,8));
    }
}
