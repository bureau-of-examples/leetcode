package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.linkedlistcycleii.Solution;
import static org.junit.Assert.*;

public class LinkedListCycleIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertNull(solution.detectCycle(null));

        ListNode start = new ListNode(1);
        assertNull(solution.detectCycle(start));

        start.next = start;
        assertEquals(start, solution.detectCycle(start));

        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = start;
        assertEquals(start, solution.detectCycle(start));

        start.next.next.next = new ListNode(4);
        assertNull(solution.detectCycle(start));

        start.next.next.next.next = start.next.next;
        assertEquals(start.next.next, solution.detectCycle(start));

        assertEquals(start.next.next, solution.detectCycle(start.next));
    }
}
