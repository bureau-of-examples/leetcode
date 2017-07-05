package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/#/description
 */
public class MostFrequentSubtreeSumTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {

        private Map<Integer, Integer> freqCount = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) {
                return new int[0];
            }

            calc(root);
            int max = freqCount.values().stream().mapToInt(i -> i).max().getAsInt();
            return freqCount.entrySet().stream().filter(entry -> entry.getValue() == max).mapToInt(entry -> entry.getKey()).toArray();
        }

        private int calc(TreeNode node) {
            int sum = 0;
            if (node.left != null) {
                sum += calc(node.left);
            }
            if (node.right != null) {
                sum += calc(node.right);
            }
            sum += node.val;
            freqCount.put(sum, freqCount.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }

}
