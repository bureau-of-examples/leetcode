package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.symmetrictree.Solution;

import static org.junit.Assert.*;

public class SymmetricTreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode root = null;
        assertEquals(true, solution.isSymmetric(root));

        root = new TreeNode(5);
        assertEquals(true, solution.isSymmetric(root));

        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        assertEquals(true, solution.isSymmetric(root));

        root.left.left = new TreeNode(2);
        assertEquals(false, solution.isSymmetric(root));

        root.right.left = new TreeNode(1);
        assertEquals(false, solution.isSymmetric(root));

        root.right.right = new TreeNode(2);
        assertEquals(false, solution.isSymmetric(root));

        root.left.right = new TreeNode(1);
        assertEquals(true, solution.isSymmetric(root));
    }
}
