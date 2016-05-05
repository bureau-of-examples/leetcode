package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreeverticaltraversal.Solution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BinaryTreeVerticalTraversalTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        List<List<Integer>> result = solution.verticalOrder(null);
        assertThat(Utils.listOfListToString(result), equalTo("[]"));

        TreeNode root = new TreeNode(1000);
        result = solution.verticalOrder(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[1000]]"));

        root.left = new TreeNode(500);
        result = solution.verticalOrder(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[500],[1000]]"));

        root.right = new TreeNode(1500);
        result = solution.verticalOrder(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[500],[1000],[1500]]"));

        root.left.right = new TreeNode(750);
        result = solution.verticalOrder(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[500],[1000,750],[1500]]"));

        root.left.right.left = new TreeNode(650);
        result = solution.verticalOrder(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[500,650],[1000,750],[1500]]"));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        result = solution.verticalOrder(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[4],[9,5],[3,0,1],[8,2],[7]]"));
    }
}
