package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.closestbinarysearchtreevalue.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ClosestBinarySearchTreeValueTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(100);

        int closest = solution.closestValue(root, 100d);
        assertThat(closest, equalTo(100));

        closest = solution.closestValue(root, 50d);
        assertThat(closest, equalTo(100));

        root.left = new TreeNode(60);
        closest = solution.closestValue(root, 50d);
        assertThat(closest, equalTo(60));

        root.right = new TreeNode(110);
        closest = solution.closestValue(root, 115);
        assertThat(closest, equalTo(110));

        root.left.right = new TreeNode(70);
        closest = solution.closestValue(root, 71);
        assertThat(closest, equalTo(70));

        closest = solution.closestValue(root, 61);
        assertThat(closest, equalTo(60));

        root.right.right = new TreeNode(200);
        closest = solution.closestValue(root, 100);
        assertThat(closest, equalTo(100));
    }
}
