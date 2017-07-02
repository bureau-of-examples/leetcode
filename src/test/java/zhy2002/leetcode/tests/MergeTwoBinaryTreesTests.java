package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/#/description
 */
public class MergeTwoBinaryTreesTests {

    private static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                if (t2 == null) {
                    return null;
                } else {
                    return t2;
                }
            } else {
                if (t2 == null) {
                    return t1;
                } else {
                    t1.val += t2.val;
                    t1.left = mergeTrees(t1.left, t2.left);
                    t1.right = mergeTrees(t1.right, t2.right);
                    return t1;
                }
            }
        }
    }
}
