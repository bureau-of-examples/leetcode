package zhy2002.leetcode.tests;

import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreepreordertraversal.Solution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BinaryTreePreorderTraversalTests {

    //test by growing a tree.
    @Test
    public void basicTest() {

        Solution solution = new Solution();

        List<Integer> result = solution.preorderTraversal(null);
        assertThat(result, equalTo(new ArrayList<Integer>()));

        TreeNode root = new TreeNode(0);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0)));

        root.right = new TreeNode(100);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, 100)));

        root.left = new TreeNode(-100);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, -100, 100)));

        root.left.right = new TreeNode(-50);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, -100, -50, 100)));

        root.right.right = new TreeNode(150);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, -100, -50, 100, 150)));

        root.right.left = new TreeNode(50);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, -100, -50, 100, 50, 150)));

        root.left.right.left = new TreeNode(-75);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, -100, -50, -75, 100, 50, 150)));

        root.left.right.left.left = new TreeNode(-85);
        result = solution.preorderTraversal(root);
        assertThat(result, equalTo(Arrays.asList(0, -100, -50, -75, -85, 100, 50, 150)));

    }
}
