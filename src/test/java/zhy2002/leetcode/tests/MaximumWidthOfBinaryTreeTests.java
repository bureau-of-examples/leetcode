package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 */
public class MaximumWidthOfBinaryTreeTests {

    public static class Solution {

        private static TreeNode sentinel = new TreeNode(-1);

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            int max = 0;
            Deque<Object> queue = new ArrayDeque<>();
            queue.add(root);
            queue.add(0);
            queue.add(sentinel);

            int first = 0, last = -1;
            while (!queue.isEmpty()) {
                TreeNode node = (TreeNode)queue.poll();
                if (node == sentinel) {
                    max = Math.max(max, last - first + 1);
                    first = 0; last = -1;
                    if (!queue.isEmpty()) {
                        queue.add(sentinel);
                    }
                    continue;
                }
                int index = (int)queue.poll();
                if (last == -1) {
                    first = last = index;
                } else {
                    last = index;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(index << 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    queue.add((index << 1) + 1);
                }
            }
            return max;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.widthOfBinaryTree(Utils.stringToBinaryTree("1,3,2,5,3,null,9")), equalTo(4));
    }

}
