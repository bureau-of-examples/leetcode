package zhy2002.leetcode.tests;
import zhy2002.leetcode.solutions.removenthnodefromendoflist.Solution;
import org.junit.Test;
import zhy2002.leetcode.common.ListNode;
import static org.junit.Assert.*;

public class RemoveNthNodeFromEndOfList {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        ListNode result = solution.removeNthFromEnd(node1, 1);
        assertNull(result.next.next);

        result = solution.removeNthFromEnd(result, 2);
        assertEquals(2, result.val);
        assertNull(result.next);

    }
}
