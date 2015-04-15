package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.constructbinarytreefrominorderandpostordertraversal.Solution;
import zhy2002.leetcode.solutions.constructbinarytreefrominorderandpostordertraversal.HashMapSolution;

import static org.junit.Assert.assertEquals;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTests {

    @Test
    public void hashMapBasicTest(){
        basicTest(new HashMapSolution());
    }

    private void basicTest(Solution solution){

        TreeNode result = solution.buildTree(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        assertEquals("2 1 3", Utils.binaryTreeToString(result));

        result = solution.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 4, 3});
        assertEquals("3 2 4 1 # # 5", Utils.binaryTreeToString(result));

        result = solution.buildTree(new int[]{3, 1, 2}, new int[]{1, 3, 2});
        assertEquals("2 3 # # 1", Utils.binaryTreeToString(result));

        result = solution.buildTree(new int[]{2, 3, 4, 5, 6}, new int[]{2, 3, 5, 6, 4});
        assertEquals("4 3 6 2 # 5", Utils.binaryTreeToString(result));

        result = solution.buildTree(new int[]{2, 1}, new int[]{2, 1});
        assertEquals("1 2", Utils.binaryTreeToString(result));

    }
}
