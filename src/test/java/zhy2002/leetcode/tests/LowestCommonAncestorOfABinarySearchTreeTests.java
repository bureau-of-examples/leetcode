package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.lowestcommonancestorofabinarysearchtree.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LowestCommonAncestorOfABinarySearchTreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(100);

        TreeNode result = solution.lowestCommonAncestor(root, root, root);
        assertThat(result.val, equalTo(100));

        root.left = new TreeNode(50);
        result = solution.lowestCommonAncestor(root, root, root.left);
        assertThat(result.val, equalTo(100));

        root.right = new TreeNode(200);
        result = solution.lowestCommonAncestor(root, root.right, root.left);
        assertThat(result.val, equalTo(100));

        root.left.left = new TreeNode(25);
        result = solution.lowestCommonAncestor(root, root.left.left, root.right);
        assertThat(result.val, equalTo(100));

        root.left.right = new TreeNode(75);
        result = solution.lowestCommonAncestor(root, root.left.left, root.left.right);
        assertThat(result.val, equalTo(50));

        root.right.left = new TreeNode(150);
        result = solution.lowestCommonAncestor(root, root.right.left, root.right);
        assertThat(result.val, equalTo(200));
    }
}
