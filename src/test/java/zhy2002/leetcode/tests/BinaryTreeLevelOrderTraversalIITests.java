package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreelevelordertraversalii.Solution;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        TreeNode root = createNode();
        assertEquals("[[8,9,10,11],[4,5,6,7],[2,3],[1]]", Utils.listOfListToString(solution.levelOrderBottom(root)));

        root.left.left = null;
        assertEquals("[[10,11],[5,6,7],[2,3],[1]]", Utils.listOfListToString(solution.levelOrderBottom(root)));

        root.left.right.left = null;
        assertEquals("[[11],[5,6,7],[2,3],[1]]", Utils.listOfListToString(solution.levelOrderBottom(root)));

        root.right.right = null;
        assertEquals("[[11],[5,6],[2,3],[1]]", Utils.listOfListToString(solution.levelOrderBottom(root)));

    }

    private TreeNode createNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        return root;
    }
}
