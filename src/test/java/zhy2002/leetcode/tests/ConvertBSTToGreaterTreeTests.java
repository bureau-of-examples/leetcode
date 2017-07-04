package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class ConvertBSTToGreaterTreeTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null)
                return null;

            TreeNode right = convertBST(root.right);
            sum += root.val;
            TreeNode clone = new TreeNode(sum);
            clone.right = right;
            clone.left = convertBST(root.left);
            return clone;
        }
    }

}
