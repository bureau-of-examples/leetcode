package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.rotatelist.Solution;

import static org.junit.Assert.*;

public class RotateListTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        ListNode result = solution.rotateRight(null, 0);
        assertNull(result);

        ListNode node = new ListNode(1);
        result = solution.rotateRight(node, 0);
        assertEquals(1, result.val);

        result = solution.rotateRight(node, 1);
        assertEquals(1, result.val);

        result.next = new ListNode(2);
        result = solution.rotateRight(node, 1);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);

        node = Utils.createLinkedList(1,2);
        result = solution.rotateRight(node, 2);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);

        node = Utils.createLinkedList(1,2);
        result = solution.rotateRight(node, 4);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);

        node = Utils.createLinkedList(1, 2, 3);
        result = solution.rotateRight(node, 7);
        assertEquals(3, result.val);
        assertEquals(1, result.next.val);
        assertEquals(2, result.next.next.val);
        assertNull(result.next.next.next);

        node = Utils.createLinkedList(1, 2, 3);
        result = solution.rotateRight(node, 2);
        assertEquals(2, result.val);
        assertEquals(3, result.next.val);
        assertEquals(1, result.next.next.val);
        assertNull(result.next.next.next);

        node = Utils.createLinkedList(1, 2, 3);
        result = solution.rotateRight(node, 6);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);


    }
}
