package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.convertsortedlisttobinarysearchtree.Solution;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ConvertSortedListToBinarySearchTreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals("", Utils.binaryTreeToString(solution.sortedListToBST(Utils.createLinkedList())));
        assertEquals("1", Utils.binaryTreeToString(solution.sortedListToBST(Utils.createLinkedList(1))));
        assertEquals("1 # 2", Utils.binaryTreeToString(solution.sortedListToBST(Utils.createLinkedList(1, 2))));
        assertEquals("2 1 3", Utils.binaryTreeToString(solution.sortedListToBST(Utils.createLinkedList(1, 2, 3))));
        assertEquals("2 1 3 # # # 4", Utils.binaryTreeToString(solution.sortedListToBST(Utils.createLinkedList(1, 2, 3, 4))));
        assertEquals("3 1 4 # 2 # 5", Utils.binaryTreeToString(solution.sortedListToBST(Utils.createLinkedList(1, 2, 3, 4, 5))));
    }
}
