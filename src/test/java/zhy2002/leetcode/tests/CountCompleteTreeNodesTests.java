package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.countcompletetreenodes.DnCSolution;
import zhy2002.leetcode.solutions.countcompletetreenodes.Solution;
import zhy2002.leetcode.solutions.countcompletetreenodes.TLESolution;

import static org.junit.Assert.*;

public class CountCompleteTreeNodesTests {

    @Test
    public void tleBasicTest(){
        basicTest(new TLESolution());
    }

    @Test
    public void dncBasicTest(){
        basicTest(new DnCSolution());
    }

    private void basicTest(Solution solution) {

        assertEquals(0, solution.countNodes(null));

        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.countNodes(root));

        root.left = new TreeNode(1);
        assertEquals(2, solution.countNodes(root));

        root.right = new TreeNode(1);
        assertEquals(3, solution.countNodes(root));

        root.left.left = new TreeNode(1);
        assertEquals(4, solution.countNodes(root));

        root.left.right = new TreeNode(1);
        assertEquals(5, solution.countNodes(root));

        root.right.left = new TreeNode(1);
        assertEquals(6, solution.countNodes(root));

        root.right.right = new TreeNode(1);
        assertEquals(7, solution.countNodes(root));

        root.left.left.left = new TreeNode(1);
        assertEquals(8, solution.countNodes(root));
    }
}
