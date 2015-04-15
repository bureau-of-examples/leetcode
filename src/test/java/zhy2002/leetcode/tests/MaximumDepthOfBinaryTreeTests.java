package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.maximumdepthofbinarytree.Solution;
import static org.junit.Assert.*;

public class MaximumDepthOfBinaryTreeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.maxDepth(null));

        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.maxDepth(root));

        root.left = new TreeNode(1);
        assertEquals(2, solution.maxDepth(root));

        root.left.left = new TreeNode(1);
        assertEquals(3, solution.maxDepth(root));

        root.right = new TreeNode(1);
        assertEquals(3, solution.maxDepth(root));

        root.right.left = new TreeNode(1);
        assertEquals(3, solution.maxDepth(root));

        root.right.left.left = new TreeNode(1);
        assertEquals(4, solution.maxDepth(root));
    }
}
