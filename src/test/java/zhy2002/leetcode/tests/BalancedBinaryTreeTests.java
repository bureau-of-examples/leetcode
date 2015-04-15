package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.balancedbinarytree.Solution;
import static org.junit.Assert.*;

public class BalancedBinaryTreeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        TreeNode root = null;
        assertEquals(true,solution.isBalanced(root));

        root = new TreeNode(5);
        assertEquals(true,solution.isBalanced(root));

        root.left = new TreeNode(3);
        assertEquals(true,solution.isBalanced(root));

        root.left.right = new TreeNode(4);
        assertEquals(false,solution.isBalanced(root));

        root.right = new TreeNode(9);
        assertEquals(true,solution.isBalanced(root));

        root.left.left = new TreeNode(2);
        assertEquals(true,solution.isBalanced(root));

        root.left.left.left = new TreeNode(1);
        assertEquals(false,solution.isBalanced(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(5);
        assertEquals(true,solution.isBalanced(root));
    }
}
