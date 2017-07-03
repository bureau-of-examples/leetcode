package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/path-sum-iii/#/description
 */
public class PathSumIIITests {

    @Test
    public void test() {
        WebSolution solution = new WebSolution();
        assertThat(
                solution.pathSum(Utils.stringToBinaryTree("10,5,-3,3,2,null,11,3,-2,null,1"), 8),
                equalTo(3)
        );
    }

    public class WebSolution {
        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);  //Default sum = 0 has one count
            return backtrack(root, 0, sum, map);
        }
        //BackTrack one pass
        public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
            if(root == null)
                return 0;
            sum += root.val;
            int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
            map.put(sum, map.getOrDefault(sum, 0)+1);
            //Extend to left and right child
            res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
            map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
            return res;
        }
    }

    public class Solution {
        private int result = 0;

        public int pathSum(TreeNode root, int sum) {

            collect(root, sum, Collections.singletonList(0));
            return result;
        }

        private void collect(TreeNode node, int sum, List<Integer> upperLengths) {
            if (node == null)
                return;

            List<Integer> lengths = new ArrayList<>();
            lengths.add(0);
            for (Integer len : upperLengths) {
                int newLen = len + node.val;
                if (newLen == sum) {
                    result++;
                }
                lengths.add(newLen);
            }
            collect(node.left, sum, lengths);
            collect(node.right, sum, lengths);
        }
    }
}
