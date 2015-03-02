package zhy2002.leetcode.tests;

import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.uniquebinarysearchtreeii.Solution;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        List<TreeNode> result = solution.generateTrees(0);
        assertEquals(1, result.size());

        result = solution.generateTrees(1);
        assertEquals(1, result.size());

        result = solution.generateTrees(2);
        assertEquals(2, result.size());

        result = solution.generateTrees(3);
        assertEquals(5, result.size());

        result = solution.generateTrees(4);
        assertEquals(14, result.size());
    }
}
