package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.minimumdepthofbinarytree.RecursiveSolution;
import zhy2002.leetcode.solutions.minimumdepthofbinarytree.SlowSolution;
import zhy2002.leetcode.solutions.minimumdepthofbinarytree.Solution;

import static org.junit.Assert.*;

public class MinimumDepthOfBinaryTreeTests {

    @Test
    public void recursiveBasicTest() {
        basicTest(new RecursiveSolution());
    }

    @Test
    public void slowBasicTest() {
        basicTest(new SlowSolution());
    }

    public void basicTest(Solution solution) {
        TreeNode root = createRoot();
        assertEquals(3, solution.minDepth(root));

        root.right.left = null;
        assertEquals(2, solution.minDepth(root));

        root.right = null;
        assertEquals(4, solution.minDepth(root));
    }

    private TreeNode createRoot() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.right.left = new TreeNode(6);
        return node;
    }
}
