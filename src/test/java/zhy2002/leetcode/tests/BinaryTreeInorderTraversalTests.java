package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreeinordertraversal.Solution;
import static org.junit.Assert.*;

public class BinaryTreeInorderTraversalTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.right = new TreeNode(20);
        assertEquals("5,7,10,15,20", Utils.integersToString(solution.inorderTraversal(treeNode)));

        treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(8);
        treeNode.left.left = new TreeNode(5);
        treeNode.right = new TreeNode(11);
        assertEquals("5,8,10,11", Utils.integersToString(solution.inorderTraversal(treeNode)));
    }
}
