package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.reversenodesinkgroup.Solution;

import static org.junit.Assert.*;

public class ReverseNodesInKGroupTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        ListNode list = Utils.createLinkedList(1, 2, 3, 4, 5);
        ListNode result = solution.reverseKGroup(list, 5);
        String str = Utils.linkedListToString(result);
        assertEquals("5 4 3 2 1", str);

        list = Utils.createLinkedList(1, 2, 3, 4, 5);
        result = solution.reverseKGroup(list, 6);
        str = Utils.linkedListToString(result);
        assertEquals("1 2 3 4 5", str);

        list = Utils.createLinkedList(1, 2, 3, 4, 5);
        result = solution.reverseKGroup(list, 3);
        str = Utils.linkedListToString(result);
        assertEquals("3 2 1 4 5", str);

        list = Utils.createLinkedList(1, 2, 3, 4, 5, 6);
        result = solution.reverseKGroup(list, 2);
        str = Utils.linkedListToString(result);
        assertEquals("2 1 4 3 6 5", str);
    }
}
