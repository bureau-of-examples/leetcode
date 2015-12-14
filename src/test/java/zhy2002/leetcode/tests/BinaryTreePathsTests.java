package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreepaths.Solution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BinaryTreePathsTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);

        List<String> result = solution.binaryTreePaths(root);
        assertThat(Utils.listToString(result), equalTo("1"));

        result = solution.binaryTreePaths(null);
        assertThat(result, hasSize(0));

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        result = solution.binaryTreePaths(root);
        assertThat(Utils.listToString(result), equalTo("1->2 1->3"));

        root.left.right = new TreeNode(5);
        result = solution.binaryTreePaths(root);
        assertThat(Utils.listToString(result), equalTo("1->2->5 1->3"));
    }
}
