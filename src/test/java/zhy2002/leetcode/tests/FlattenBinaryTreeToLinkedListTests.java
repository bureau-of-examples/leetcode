package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.flattenbinarytreetolinkedlist.Solution;

import static org.junit.Assert.*;

public class FlattenBinaryTreeToLinkedListTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);

        solution.flatten(node);
        assertEquals("1 # 2 # 3 # 4 # 5 # 6", Utils.binaryTreeToString(node));
    }
}
