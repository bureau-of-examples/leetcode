package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.sumroottoleafnumbers.Solution;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(0, solution.sumNumbers(null));
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.sumNumbers(root));
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        assertEquals(251, solution.sumNumbers(root));
    }
}
