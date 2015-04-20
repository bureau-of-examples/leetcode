package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarytreerightsideview.DFSSolution;
import zhy2002.leetcode.solutions.binarytreerightsideview.LevelOrderSolution;
import zhy2002.leetcode.solutions.binarytreerightsideview.Solution;
import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTests {

    @Test
    public void levelOrderBasicTest(){
        basicTest(new LevelOrderSolution());
    }

    @Test
    public void dfsBasicTest(){
        basicTest(new DFSSolution());
    }

   private void basicTest(Solution solution){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertEquals("1,3", Utils.integersToString( solution.rightSideView(root)));

        root.left.right = new TreeNode(5);
        assertEquals("1,3,5", Utils.integersToString( solution.rightSideView(root)));

        root.left.left = new TreeNode(4);
        assertEquals("1,3,5", Utils.integersToString( solution.rightSideView(root)));

        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        assertEquals("1,3,6,8", Utils.integersToString( solution.rightSideView(root)));
    }
}
