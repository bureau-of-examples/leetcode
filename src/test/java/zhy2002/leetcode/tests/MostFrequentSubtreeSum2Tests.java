package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/#/description
 */
public class MostFrequentSubtreeSum2Tests {

    public class Solution {

        private int maxCount = 0;
        private Map<Integer, Integer> sumCount;

        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null)
                return new int[0];

            maxCount = 0;
            sumCount = new HashMap<>();
            calcSum(root);
            return sumCount.entrySet().stream()
                    .filter(e -> e.getValue() == maxCount)
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }

        private int calcSum(TreeNode node) {
            int sum = node.val;
            if (node.left != null) {
                sum += calcSum(node.left);
            }
            if (node.right != null) {
                sum += calcSum(node.right);
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            maxCount = Math.max(maxCount, sumCount.get(sum));
            return sum;
        }
    }

    @Test
    public void test() {
        Scanner scanner;

        assertThat(true, equalTo(true));
    }

}
