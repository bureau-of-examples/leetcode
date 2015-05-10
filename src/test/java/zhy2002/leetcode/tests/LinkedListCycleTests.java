package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.linkedlistcycle.Solution;
import static org.junit.Assert.*;

public class LinkedListCycleTests {
    
    @Test
    public void basicTest(){
        
        Solution solution = new Solution();
        assertEquals(false, solution.hasCycle(null));
        
        ListNode node1 = new ListNode(1);
        assertEquals(false, solution.hasCycle(node1));

        ListNode node2 = new ListNode(2);
        node1.next = node2;
        assertEquals(false, solution.hasCycle(node1));

        ListNode node3 = new ListNode(3);
        node2.next = node3;
        assertEquals(false, solution.hasCycle(node1));

        node1.next = node1;
        assertEquals(true, solution.hasCycle(node1));

        node1.next = node2;
        node2.next = node2;
        assertEquals(true, solution.hasCycle(node1));

        node2.next = node3;
        node3.next = node2;
        assertEquals(true, solution.hasCycle(node1));

        node3.next = node1;
        assertEquals(true, solution.hasCycle(node1));

        ListNode node0 = new ListNode(0);
        node0.next = node1;
        assertEquals(true, solution.hasCycle(node0));

        node3.next = node2;
        assertEquals(true, solution.hasCycle(node0));

        node3.next = null;
        assertEquals(false, solution.hasCycle(node0));
        
    }
}
