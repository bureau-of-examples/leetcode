package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.validatebinarysearchtree.Solution;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(true, solution.isValidBST(null));
        TreeNode node = new TreeNode(0);
        assertEquals(true, solution.isValidBST(node));

        node.left = new TreeNode(3);
        assertEquals(false, solution.isValidBST(node));

        node.left = new TreeNode(-3);
        node.left.right = new TreeNode(-1);
        assertEquals(true, solution.isValidBST(node));

        node.left.left = new TreeNode(-8);
        assertEquals(true, solution.isValidBST(node));

        node.left.left.left = new TreeNode(-8);
        assertEquals(false, solution.isValidBST(node));

        node.left.left.left = null;
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(10);
        assertEquals(true, solution.isValidBST(node));

        node.right.left = new TreeNode(-1);
        assertEquals(false, solution.isValidBST(node));

        node = new TreeNode(-2147483648);
        node.left = new TreeNode(-2147483648);

        assertEquals(false, solution.isValidBST(node));
    }
}
