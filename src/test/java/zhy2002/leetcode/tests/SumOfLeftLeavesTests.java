package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/#/description
 */
public class SumOfLeftLeavesTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {

        public int sumOfLeftLeaves(TreeNode root) {
            return findSum(root, null);
        }

        private int findSum(TreeNode node, TreeNode parent) {
            if (node == null)
                return 0;
            if (node.left == null && node.right == null && parent != null && node == parent.left) {
                return node.val;
            }

            return findSum(node.left, node) + findSum(node.right, node);
        }
    }
}
