package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/#/description
 */
public class FindBottomLeftTreeValueTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int leftMost = -1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            boolean isFirst = true;
            while (true) {
                TreeNode node = queue.poll();
                if (node == null) {
                    if (queue.isEmpty())
                        break;
                    queue.add(null);
                    isFirst = true;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }

                    if (isFirst) {
                        leftMost = node.val;
                        isFirst = false;
                    }
                }
            }
            return leftMost;
        }
    }

}
