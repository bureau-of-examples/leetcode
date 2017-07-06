package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/boundary-of-binary-tree/#/description
 */
public class BoundaryOfBinaryTreeTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.boundaryOfBinaryTree(Utils.stringToBinaryTree("1,2,3,4,5,6,null,null,null,7,8,9,10")), equalTo(Arrays.asList(1, 2, 4, 7, 8, 9, 10, 6, 3)));
        assertThat(solution.boundaryOfBinaryTree(Utils.stringToBinaryTree("10")), equalTo(Arrays.asList(10)));
        assertThat(solution.boundaryOfBinaryTree(Utils.stringToBinaryTree("10,11")), equalTo(Arrays.asList(10, 11)));
        assertThat(solution.boundaryOfBinaryTree(Utils.stringToBinaryTree("10,11,12")), equalTo(Arrays.asList(10, 11, 12)));
        assertThat(solution.boundaryOfBinaryTree(Utils.stringToBinaryTree("10,11,12,13,14,15,16")), equalTo(Arrays.asList(10, 11, 13, 14, 15, 16, 12)));
        assertThat(solution.boundaryOfBinaryTree(Utils.stringToBinaryTree("10,11,16,12,13,null,17,null,null,14,15")), equalTo(Arrays.asList(10, 11, 12, 14, 15, 17, 16)));
    }

    public class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                result.add(root.val);
                find(result, root.left, 'L');
                find(result, root.right, 'R');
            }
            return result;
        }

        private void find(List<Integer> result, TreeNode node, char pos) {
            if (node == null)
                return;
            if (node.left == null && node.right == null) {
                result.add(node.val);
                return;
            }

            if (pos == 'L') {
                result.add(node.val);
            }
            find(result, node.left, pos == 'L' ? 'L' : node.right == null && pos == 'R' ? 'R' : '-');
            find(result, node.right, pos == 'R' ? 'R' : node.left == null && pos == 'L' ? 'L' : '-');
            if (pos == 'R') {
                result.add(node.val);
            }
        }
    }

}
