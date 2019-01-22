package zhy2002.leetcode.tests;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] result = solution.findMode(Utils.stringToBinaryTree("1,1,2,null,null,2"));
        //int[] result = solution.findMode(Utils.stringToBinaryTree("1,1,2"));

        for (int i : result) {
            System.out.println(i);
        }
    }

    private static class Solution {

        private List<Integer> result;
        private int maxFrequency;
        private Integer prev;
        private int frequency;

        public int[] findMode(TreeNode root) {
            result = new ArrayList<>();
            maxFrequency = 0;
            prev = null;
            frequency = 0;

            inOrder(root);
            return result.stream().mapToInt(i -> i).toArray();
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);

            if (prev == null || prev == root.val) {
                frequency++;
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    result.clear();
                }
            } else {
                frequency = 1;
            }
            if (frequency == maxFrequency) {
                result.add(root.val);
            }
            prev = root.val;

            inOrder(root.right);
        }
    }
}
