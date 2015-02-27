package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.pathsumii.Solution;
import static org.junit.Assert.*;
import java.util.List;

public class PathSumIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        List<List<Integer>> result = solution.pathSum(null, 0);
        assertEquals(0, result.size());

        result = solution.pathSum(new TreeNode(5), 0);
        assertEquals(0, result.size());

        result = solution.pathSum(new TreeNode(5), 5);
        assertEquals(1, result.size());

        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(12);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(2);
        result = solution.pathSum(root, 8);
        assertEquals(1, result.size());
        assertEquals("9,-3,2", Utils.integersToString(result.get(0)));

        result = solution.pathSum(root, 21);
        assertEquals(1, result.size());
        assertEquals("9,12", Utils.integersToString(result.get(0)));

        result = solution.pathSum(root, 6);
        assertEquals(0, result.size());

        root.left.left = new TreeNode(-13);
        result = solution.pathSum(root, 8);
        assertEquals(2, result.size());
    }
}
