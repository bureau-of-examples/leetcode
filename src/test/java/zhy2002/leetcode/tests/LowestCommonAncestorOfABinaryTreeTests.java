package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.lowestcommonancestorofabinarytree.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LowestCommonAncestorOfABinaryTreeTests {

    @Test
    public void basicTest(){

        TreeNode root = new TreeNode(100);
        Solution solution = new Solution();

        TreeNode result = solution.lowestCommonAncestor(root, root, root);
        assertThat(result, sameInstance(root));

        root.left = new TreeNode(20);
        result = solution.lowestCommonAncestor(root, root.left, root);
        assertThat(result, sameInstance(root));

        root.right = new TreeNode(50);
        result = solution.lowestCommonAncestor(root, root.right, root.left);
        assertThat(result, sameInstance(root));

        result = solution.lowestCommonAncestor(root, root.left, root.left);
        assertThat(result, sameInstance(root.left));

        root.left.left = new TreeNode(40);
        result = solution.lowestCommonAncestor(root, root.left, root.left.left);
        assertThat(result, sameInstance(root.left));

        root.left.right = new TreeNode(44);
        result = solution.lowestCommonAncestor(root, root.left.right, root.left.left);
        assertThat(result, sameInstance(root.left));

        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(18);
        result = solution.lowestCommonAncestor(root, root.right.right, root.left.left);
        assertThat(result, sameInstance(root));

        root.right.right.left = new TreeNode(77);
        result = solution.lowestCommonAncestor(root, root.right.right.left, root.right.left);
        assertThat(result, sameInstance(root.right));

        root.left.left.right = new TreeNode(102);
        result = solution.lowestCommonAncestor(root, root.left.left.right, root.right.right.left);
        assertThat(result, sameInstance(root));

        result = solution.lowestCommonAncestor(root, root.left.left.right, new TreeNode(13));
        assertThat(result, nullValue());

    }

}
