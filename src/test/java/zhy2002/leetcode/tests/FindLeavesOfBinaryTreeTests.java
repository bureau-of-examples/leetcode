package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.findleavesofbinarytree.Solution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FindLeavesOfBinaryTreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(10);
        List<List<Integer>> result = solution.findLeaves(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[10]]"));

        root.left = new TreeNode(3);
        result = solution.findLeaves(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[3],[10]]"));

        root.right = new TreeNode(20);
        result = solution.findLeaves(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[3,20],[10]]"));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        result = solution.findLeaves(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[1,2,20],[3],[10]]"));

        root.right.right = new TreeNode(50);
        result = solution.findLeaves(root);
        assertThat(Utils.listOfListToString(result), equalTo("[[1,2,50],[3,20],[10]]"));
    }
}
