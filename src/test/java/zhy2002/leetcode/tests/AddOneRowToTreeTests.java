package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/#/description
 */
public class AddOneRowToTreeTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                Utils.binaryTreeToString(solution.addOneRow(Utils.stringToBinaryTree("5,6"), 10, 2)),
                equalTo("5 10 10 6")
        );

        assertThat(
                Utils.binaryTreeToString(solution.addOneRow(Utils.stringToBinaryTree("5"), 10, 1)),
                equalTo("10 5")
        );
    }

    public class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            return add(null, root, v, d);
        }

        private TreeNode add(TreeNode parent, TreeNode node, int v, int d) {
            if (d == 1) {
                TreeNode additional = new TreeNode(v);
                if (parent == null) {
                    additional.left = node;
                } else if (parent.left == node) {
                    parent.left = additional;
                    additional.left = node;
                } else {
                    parent.right = additional;
                    additional.right = node;
                }
                return additional;
            }
            if (node != null) {
                node.left = add(node, node.left, v, d - 1);
                node.right = add(node, node.right, v, d - 1);
            }
            return node;
        }

    }
}
