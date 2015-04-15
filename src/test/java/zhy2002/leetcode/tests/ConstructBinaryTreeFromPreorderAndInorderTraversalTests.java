package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.constructbinarytreefrompreorderandinordertraversal.Solution;

import static org.junit.Assert.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode result = solution.buildTree(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        assertEquals("1 # 2 3", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        assertEquals("1 2 # 3", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertEquals("1 # 2 # 3", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 4, 3});
        assertEquals("1 # 2 # 3 4 # 5", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{2, 3, 4, 5, 6}, new int[]{2, 3, 5, 6, 4});
        assertEquals("2 # 3 # 4 5 # # 6", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{}, new int[]{});
        assertEquals("", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{2, 1}, new int[]{2, 1});
        assertEquals("2 # 1", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{3}, new int[]{3});
        assertEquals("3", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{3, 1, 2}, new int[]{1, 3, 2});
        assertEquals("3 1 2", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{2, 1}, new int[]{2, 1});
        assertEquals("2 # 1", Utils.binaryTreeToString(result));
        result = solution.buildTree(new int[]{1, 2}, new int[]{1, 2});
        assertEquals("1 # 2", Utils.binaryTreeToString(result));


    }

    @Test
    public void treeToStringTest(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        assertEquals("1 2 3 # # 4 # # 5", Utils.binaryTreeToString(root));
    }
}
