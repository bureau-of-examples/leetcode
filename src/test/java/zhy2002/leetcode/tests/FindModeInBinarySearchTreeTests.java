package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/#/description
 */
public class FindModeInBinarySearchTreeTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findMode(Utils.stringToBinaryTree("1,0,null,null,2,2")),
                equalTo(new int[]{2})
        );
        assertThat(
                solution.findMode(Utils.stringToBinaryTree("10,10,10,1,null,null,20,null,null,20,20")),
                equalTo(new int[]{10, 20})
        );
    }

    public class Solution {
        private int maxCount;
        private int currentCount;
        private int currentValue;
        private int[] modes = new int[0];

        public int[] findMode(TreeNode root) {
            if (root != null) {
                find(root);
                collectModes();
            }
            return modes;

        }

        private void find(TreeNode node) {
            if (node.left != null) {
                find(node.left);
            }

            if (currentCount == 0) { //first
                currentCount = 1;
                currentValue = node.val;
            } else {
                if (currentValue == node.val) {
                    currentCount++;
                } else {
                    collectModes();
                    currentCount = 1;
                    currentValue = node.val;
                }
            }

            if (node.right != null) {
                find(node.right);
            }
        }

        private void collectModes() {
            if (currentCount > maxCount) {
                maxCount = currentCount;
                modes = new int[]{currentValue};
            } else if (currentCount == maxCount) {
                modes = Arrays.copyOf(modes, modes.length + 1);
                modes[modes.length - 1] = currentValue;
            }
        }
    }

}
