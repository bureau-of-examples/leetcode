package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.reorderlist.Solution;

import static org.junit.Assert.*;

public class ReorderListTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        ListNode root = null;
        solution.reorderList(root);

        root = new ListNode(1);
        solution.reorderList(root);
        assertNull(root.next);

        root.next = new ListNode(2);
        solution.reorderList(root);
        assertEquals(2, root.next.val);
        assertNull(root.next.next);

        root.next.next = new ListNode(3);
        solution.reorderList(root);
        assertEquals(3, root.next.val);
        assertEquals(2, root.next.next.val);

        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        solution.reorderList(root);
        assertEquals(4, root.next.val);
        assertEquals(2, root.next.next.val);
        assertEquals(3, root.next.next.next.val);


    }
}
