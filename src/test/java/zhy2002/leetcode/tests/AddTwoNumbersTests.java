package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.addtwonumbers.NoSentinelSolution;
import zhy2002.leetcode.solutions.addtwonumbers.ReferenceSolution;
import zhy2002.leetcode.solutions.addtwonumbers.Solution;
import static org.junit.Assert.*;


public class AddTwoNumbersTests {

    @Test
    public void noSentinelBasicTest(){
        basicTest(new NoSentinelSolution());
    }

    @Test
    public void referenceBasicTest(){
        basicTest(new ReferenceSolution());
    }

    private void basicTest(Solution solution){
        ListNode result = solution.addTwoNumbers(null, null);
        assertNull(result);

        result = solution.addTwoNumbers(new ListNode(5), null);
        assertEquals(5, result.val);

        result = solution.addTwoNumbers(new ListNode(5), new ListNode(5));
        assertEquals(0, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);

        ListNode left = new ListNode(9);
        left.next = new ListNode(9);

        ListNode right = new ListNode(9);
        right.next = new ListNode(0);
        right.next.next = new ListNode(0);
        right.next.next.next = new ListNode(1);
        result = solution.addTwoNumbers(left, right);
        assertEquals(8, result.val);
        assertEquals(0, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(1, result.next.next.next.val);
        assertNull(result.next.next.next.next);

    }
}
