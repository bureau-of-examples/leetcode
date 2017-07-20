package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ClosestBinarySearchTreeValueTests {

    public class Solution2 {
        public int closestValue(TreeNode root, double target) {
            TreeNode closest = null;
            TreeNode node = root;
            while (node != null) {
                if (closest == null || Math.abs(target - node.val) < Math.abs(target - closest.val)) {
                    closest = node;
                    if (closest.val == target)
                        return closest.val;
                }
                node = target < node.val ? node.left : node.right;
            }
            return closest.val;
        }
    }

    @Test
    public void basicTest() {
        Solution2 solution = new Solution2();
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
