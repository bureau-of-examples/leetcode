package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.largestbstsubtree.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LargestBSTSubtreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        int result = solution.largestBSTSubtree(null);
        assertThat(result, equalTo(0));

        TreeNode root = new TreeNode(100);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(1));

        root.left = new TreeNode(50);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(2));

        root.right = new TreeNode(150);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(3));

        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(5));

        root.right.right = new TreeNode(120);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(3));

        root.right.right.left = new TreeNode(100);
        root.right.right.right = new TreeNode(130);
        root.right.right.right.left = new TreeNode(120);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(4));

        root.right.right.right.right = new TreeNode(1);
        result = solution.largestBSTSubtree(root);
        assertThat(result, equalTo(3));
    }
}
