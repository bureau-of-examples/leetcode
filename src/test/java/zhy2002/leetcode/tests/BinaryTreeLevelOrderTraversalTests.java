package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreelevelordertraversal.Solution;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(7);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(9);
        List<List<Integer>> result = solution.levelOrder(node);
        assertEquals("[[1],[2,3],[5,7],[9]]", Utils.listOfListToString(result));
    }
}
