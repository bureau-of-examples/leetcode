package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/house-robber-iii/description/
 */
public class HouseRobberIIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.rob(Utils.stringToBinaryTree("4,1,null,2,null,3")),
                equalTo(7)
        );
        assertThat(
                solution.rob(Utils.stringToBinaryTree("3,4,5,1,3,null,1")),
                equalTo(9)
        );
        assertThat(
                solution.rob(Utils.stringToBinaryTree("3,2,3,null,3,null,1")),
                equalTo(7)
        );
    }

    public class Solution {

        private Map<TreeNode, Integer> robGain;
        private Map<TreeNode, Integer> noRobGain;

        public int rob(TreeNode root) {
            if (root == null)
                return 0;
            robGain = new HashMap<>();
            noRobGain = new HashMap<>();
            populate(root);
            return Math.max(robGain.get(root), noRobGain.get(root));
        }

        private void populate(TreeNode node) {
            if (node == null)
                return;
            populate(node.left);
            populate(node.right);
            int robMax = node.val;
            int noRobMax = 0;
            if (node.left != null) {
                robMax += noRobGain.get(node.left);
                noRobMax += Math.max(robGain.get(node.left), noRobGain.get(node.left));
            }
            if (node.right != null) {
                robMax += noRobGain.get(node.right);
                noRobMax += Math.max(robGain.get(node.right), noRobGain.get(node.right));
            }
            robGain.put(node, robMax);
            noRobGain.put(node, noRobMax);
        }
    }

}
