package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreepostordertraversal.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePostorderTraversalTests {

    @Test
    public void recursiveTest(){
        basicTest(new RecursiveSolution());
    }

    @Test
    public void iterativeTest(){
        basicTest(new IterativeSolution());
    }

    //check the result is correct as the input tree grows
    private void basicTest(Solution solution){

        //arrange
        TreeNode root = null;
        //action
        List<Integer> result = solution.postorderTraversal(root);
        //assertion
        assertEquals(new ArrayList<>(), result);

        root = new TreeNode(5);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(5), result);

        root.left = new TreeNode(4);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(4, 5), result);

        root.right = new TreeNode(8);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(4, 8, 5), result);

        root.left.left = new TreeNode(1);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(1, 4, 8, 5), result);

        root.right.left = new TreeNode(7);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(1, 4, 7, 8, 5), result);

        root.right.left.right = new TreeNode(0);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(1, 4, 0, 7, 8, 5), result);

        root.left.left.right = new TreeNode(11);
        result = solution.postorderTraversal(root);
        assertEquals(Arrays.asList(11, 1, 4, 0, 7, 8, 5), result);

    }
}
