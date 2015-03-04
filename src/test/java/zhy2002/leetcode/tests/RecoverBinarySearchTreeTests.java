package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.recoverbinarysearchtree.Solution;
import static org.junit.Assert.*;

public class RecoverBinarySearchTreeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        solution.recoverTree(null);

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(150);
        root.right = new TreeNode(50);
        solution.recoverTree(root);
        assertEquals(50, root.left.val);
        assertEquals(150, root.right.val);

        root = new TreeNode(300);
        root.right = new TreeNode(200);
        root.right.right = new TreeNode(100);
        solution.recoverTree(root);
        assertEquals(100, root.val);
        assertEquals(300, root.right.right.val);

        root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(205);
        root.right.right = new TreeNode(20);
        solution.recoverTree(root);
        assertEquals(20, root.left.left.val);
        assertEquals(205, root.right.right.val);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        solution.recoverTree(root);
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);

        root = new TreeNode(0);
        root.left = new TreeNode(1);
        solution.recoverTree(root);
        assertEquals(1, root.val);
        assertEquals(0, root.left.val);
    }
}
