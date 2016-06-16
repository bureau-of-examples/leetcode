package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.inordersuccessorinbst.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InOrderSuccessorInBSTTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(100);
        TreeNode result = solution.inorderSuccessor(root, root);
        assertThat(result, nullValue());

        root.left = new TreeNode(50);
        result = solution.inorderSuccessor(root, root);
        assertThat(result, nullValue());

        result = solution.inorderSuccessor(root, root.left);
        assertThat(result, sameInstance(root));

        root.right = new TreeNode(150);
        root.right.left = new TreeNode(120);
        result = solution.inorderSuccessor(root, root);
        assertThat(result, sameInstance(root.right.left));

        root.right.right = new TreeNode(200);
        result = solution.inorderSuccessor(root, root.right.right);
        assertThat(result, nullValue());

        root.left.left = new TreeNode(20);
        result = solution.inorderSuccessor(root.left, root.left);
        assertThat(result, nullValue());
    }
}
