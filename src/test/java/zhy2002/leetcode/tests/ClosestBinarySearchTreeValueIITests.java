package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.closestbinarysearchtreevalueii.Solution;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ClosestBinarySearchTreeValueIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        TreeNode root = new TreeNode(100);

        List<Integer> result = solution.closestKValues(root, 200, 1);
        assertThat(Utils.integersToString(result), equalTo("100"));

        root.left = new TreeNode(50);
        result = solution.closestKValues(root, 200, 1);
        assertThat(Utils.integersToString(result), equalTo("100"));

        result = solution.closestKValues(root, 200, 2);
        assertThat(Utils.integersToString(result), equalTo("100,50"));

        result = solution.closestKValues(root, 10, 2);
        assertThat(Utils.integersToString(result), equalTo("50,100"));

        root.right = new TreeNode(110);
        result = solution.closestKValues(root, 101, 2);
        assertThat(Utils.integersToString(result), equalTo("100,110"));

        root.right.right = new TreeNode(150);
        result = solution.closestKValues(root, 101, 3);
        assertThat(Utils.integersToString(result), equalTo("100,110,150"));

        root.left.left = new TreeNode(10);
        result = solution.closestKValues(root, 79, 2);
        assertThat(Utils.integersToString(result), equalTo("100,50"));

        root.left.right = new TreeNode(70);
        result = solution.closestKValues(root, 79, 2);
        assertThat(Utils.integersToString(result), equalTo("70,100"));

        root.left.right.left = new TreeNode(65);
        result = solution.closestKValues(root, 79, 3);
        assertThat(Utils.integersToString(result), equalTo("70,65,100"));


    }
}
