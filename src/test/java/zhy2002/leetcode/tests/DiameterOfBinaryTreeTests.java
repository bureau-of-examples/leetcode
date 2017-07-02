package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/#/description
 */
public class DiameterOfBinaryTreeTests {

    @Test
    public void test() {
        TreeNode root = Utils.stringToBinaryTree("4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2");
        Solution solution = new Solution();

        assertThat(solution.diameterOfBinaryTree(root), equalTo(8));
    }

    public class Solution {
        private Map<TreeNode, Integer> depthCache = new HashMap<>();
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            calcDiameter(root);
            return maxDiameter;
        }

        private void calcDiameter(TreeNode node) {
            if (node == null)
                return;

            int leftLen = calcDepth(node.left) + 1;
            int rightLen = calcDepth(node.right) + 1;
            int diameter = leftLen + rightLen;
            if (diameter > maxDiameter) {
                maxDiameter = diameter;
            }

            calcDiameter(node.left);
            calcDiameter(node.right);
        }

        private int calcDepth(TreeNode node) {
            if (node == null)
                return -1;

            if (depthCache.containsKey(node))
                return depthCache.get(node);

            int depth = Math.max(calcDepth(node.left), calcDepth(node.right)) + 1;
            depthCache.put(node, depth);
            return depth;
        }
    }
}
