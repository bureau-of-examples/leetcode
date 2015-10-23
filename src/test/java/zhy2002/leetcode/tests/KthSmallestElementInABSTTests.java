package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.kthsmallestelementinabst.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class KthSmallestElementInABSTTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        TreeNode root = new TreeNode(100);
        assertThat(solution.kthSmallest(root, 1), equalTo(100));

        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        assertThat(solution.kthSmallest(root, 1), equalTo(50));
        assertThat(solution.kthSmallest(root, 2), equalTo(100));
        assertThat(solution.kthSmallest(root, 3), equalTo(200));

        root.left.right = new TreeNode(75);
        root.left.left = new TreeNode(25);
        assertThat(solution.kthSmallest(root, 1), equalTo(25));
        assertThat(solution.kthSmallest(root, 2), equalTo(50));

        root.right.right = new TreeNode(250);
        assertThat(solution.kthSmallest(root, 6), equalTo(250));
    }
}
