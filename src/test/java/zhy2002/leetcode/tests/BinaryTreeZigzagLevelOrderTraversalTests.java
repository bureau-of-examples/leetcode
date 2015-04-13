package zhy2002.leetcode.tests;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreezigzaglevelordertraversal.Solution;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeZigzagLevelOrderTraversalTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        TreeNode root = null;
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        assertEquals("[]", Utils.listOfListToString(result));
        root = buildTestTree();
        result = solution.zigzagLevelOrder(root);
        assertEquals("[[1],[3,2],[4,5,6,7],[15,14,13,12,11,10,9,8]]", Utils.listOfListToString(result));

        root.left.left = null;
        result = solution.zigzagLevelOrder(root);
        assertEquals("[[1],[3,2],[5,6,7],[15,14,13,12,11,10]]", Utils.listOfListToString(result));

        root.right.left.left = null;
        result = solution.zigzagLevelOrder(root);
        assertEquals("[[1],[3,2],[5,6,7],[15,14,13,11,10]]", Utils.listOfListToString(result));

        root.right.right = null;
        result = solution.zigzagLevelOrder(root);
        assertEquals("[[1],[3,2],[5,6],[13,11,10]]", Utils.listOfListToString(result));
    }

    private TreeNode buildTestTree() {
        TreeNode root;
        root = new TreeNode(1);
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
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        return root;
    }
}
