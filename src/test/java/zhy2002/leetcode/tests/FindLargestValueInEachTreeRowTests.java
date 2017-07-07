package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/#/description
 */
public class FindLargestValueInEachTreeRowTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root != null) {
                int max = Integer.MIN_VALUE;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                queue.add(null);

                while (true) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        result.add(max);
                        max = Integer.MIN_VALUE;

                        if (queue.isEmpty())
                            break;
                        queue.add(null);
                    } else {
                        max = Math.max(max, node.val);
                        if (node.left != null) {
                            queue.add(node.left);
                        }
                        if (node.right != null) {
                            queue.add(node.right);
                        }
                    }
                }
            }

            return result;
        }
    }
}
