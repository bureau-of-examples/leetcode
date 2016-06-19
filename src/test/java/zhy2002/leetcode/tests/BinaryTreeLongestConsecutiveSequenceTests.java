package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreelongestconsecutivesequence.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BinaryTreeLongestConsecutiveSequenceTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        int result = solution.longestConsecutive(null);
        assertThat(result, equalTo(0));

        TreeNode root = new TreeNode(10);
        result = solution.longestConsecutive(root);
        assertThat(result, equalTo(1));

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        result = solution.longestConsecutive(root);
        assertThat(result, equalTo(1));

        root.left = new TreeNode(11);
        result = solution.longestConsecutive(root);
        assertThat(result, equalTo(2));

        TreeNode root2 = new TreeNode(17);
        root2.right = root;
        root2.left = new TreeNode(1);
        result = solution.longestConsecutive(root);
        assertThat(result, equalTo(2));

    }
}
