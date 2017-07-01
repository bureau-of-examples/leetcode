package zhy2002.leetcode.tests;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-tilt/#/description
 */
public class BinaryTreeTiltTests {

    public class Solution {

        private List<Integer> tiltList = new ArrayList<>();

        public int findTilt(TreeNode root) {
            findSum(root);
            return tiltList.stream().mapToInt(i -> i).sum();
        }

        private int findSum(TreeNode node) {
            if (node == null)
                return 0;
            int sumLeft = findSum(node.left);
            int sumRight = findSum(node.right);
            tiltList.add(Math.abs(sumRight - sumLeft));
            return node.val + sumLeft + sumRight;
        }
    }

}
