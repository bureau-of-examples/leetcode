package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/#/description
 */
public class MinimumAbsoluteDifferenceInBSTTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.getMinimumDifference(Utils.stringToBinaryTree("3,1")), equalTo(2));
        solution = new Solution();
        assertThat(solution.getMinimumDifference(
                Utils.stringToBinaryTree("3,1,4")),
                equalTo(1)
        );

        solution = new Solution();
        assertThat(solution.getMinimumDifference(
                Utils.stringToBinaryTree("3,1,4,-5,2")),
                equalTo(1)
        );
    }

    public class Solution {
        private int minDiff = Integer.MAX_VALUE;
        private int maxValue = Integer.MIN_VALUE;

        public int getMinimumDifference(TreeNode root) {
            traversal(root); //from min to max
            return minDiff;
        }

        private void traversal(TreeNode node) {
            if (node.left == null) {
                if (maxValue != Integer.MIN_VALUE) {
                    minDiff = Math.min(minDiff, node.val - maxValue);
                }
            } else {
                traversal(node.left);
                minDiff = Math.min(minDiff, node.val - maxValue);
            }
            maxValue = node.val;
            if (node.right != null) {
                traversal(node.right);
            }
        }
    }
}
