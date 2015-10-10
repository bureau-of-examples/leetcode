package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import zhy2002.leetcode.solutions.binarytreeupsidedown.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BinaryTreeUpsideDownTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode result = solution.upsideDownBinaryTree(root);
        String resultString = Utils.binaryTreeToString(result);
        assertThat(resultString, equalTo("4 5 2 # # 3 1"));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        result = solution.upsideDownBinaryTree(root);
        resultString = Utils.binaryTreeToString(result);
        assertThat(resultString, equalTo("2 # 1"));


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        result = solution.upsideDownBinaryTree(root);
        resultString = Utils.binaryTreeToString(result);
        assertThat(resultString, equalTo("4 # 3 # 2 # 1"));
    }
}
