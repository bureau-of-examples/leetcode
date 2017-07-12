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
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class AverageOfLevelsInBinaryTreeTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root != null) {
                double sum = 0;
                int count = 0;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                queue.add(null);
                while (true) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        result.add(sum / count);
                        sum = 0;
                        count = 0;
                        if (queue.isEmpty())
                            break;

                        queue.add(null);
                    } else {
                        sum += node.val;
                        count++;
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
