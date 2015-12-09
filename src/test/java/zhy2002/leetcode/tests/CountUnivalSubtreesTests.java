package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.countunivaluesubtrees.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountUnivalSubtreesTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        int count = solution.countUnivalSubtrees(root);
        assertThat(count, equalTo(1));

        root.left = new TreeNode(2);
        count = solution.countUnivalSubtrees(root);
        assertThat(count, equalTo(1));

        root.left.left = new TreeNode(2);
        count = solution.countUnivalSubtrees(root);
        assertThat(count, equalTo(2));

        root.right = new TreeNode(1);
        count = solution.countUnivalSubtrees(root);
        assertThat(count, equalTo(3));


    }
}
