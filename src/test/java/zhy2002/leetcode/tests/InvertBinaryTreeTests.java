package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.invertbinarytree.Solution;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class InvertBinaryTreeTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        TreeNode root = new TreeNode(0);
        TreeNode result = solution.invertTree(root);

        assertThat(Utils.binaryTreeToString(result), equalTo("0"));

        root.left = new TreeNode(-1);
        root.right = new TreeNode(1);
        result = solution.invertTree(root);

        assertThat(Utils.binaryTreeToString(result), equalTo("0 1 -1"));

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(20);
        result = solution.invertTree(root);

        assertThat(Utils.binaryTreeToString(result), equalTo("0 -1 1 # # 20 10"));

        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(40);
        result = solution.invertTree(root);

        assertThat(Utils.binaryTreeToString(result), equalTo("0 1 -1 10 20 40 30"));

    }
}
