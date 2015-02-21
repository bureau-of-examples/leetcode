package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.sametree.Solution;

import static org.junit.Assert.*;

public class SameTreeTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        TreeNode p = null;
        TreeNode q = null;

        assertTrue(solution.isSameTree(p, q));
        p = new TreeNode(1);
        assertTrue(!solution.isSameTree(p, q));

        q = new TreeNode(2);
        assertTrue(!solution.isSameTree(p, q));

        q.val = 1;
        assertTrue(solution.isSameTree(p, q));

        q.left = new TreeNode(5);
        assertTrue(!solution.isSameTree(p, q));

        p.left = new TreeNode(5);
        assertTrue(solution.isSameTree(p, q));

        q.right = new TreeNode(6);
        p.right = new TreeNode(7);
        assertTrue(!solution.isSameTree(p, q));

        p.right.val = 6;
        assertTrue(solution.isSameTree(p, q));

        p.left.right = new TreeNode(2);
        q.left.right = new TreeNode(2);
        assertTrue(solution.isSameTree(p, q));

        p.left.right.left = new TreeNode(9);
        assertTrue(!solution.isSameTree(p, q));

        q.left.right.left = new TreeNode(8);
        assertTrue(!solution.isSameTree(p, q));
    }
}
