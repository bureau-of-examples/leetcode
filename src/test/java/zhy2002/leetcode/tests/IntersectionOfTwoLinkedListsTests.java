package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.intersectionoftwolinkedlists.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IntersectionOfTwoLinkedListsTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode result = solution.getIntersectionNode(headA, headB);
        assertThat(result, nullValue());

        headA.next = new ListNode(3);
        result = solution.getIntersectionNode(headA, headB);
        assertThat(result, nullValue());

        headB.next = headA.next;
        result = solution.getIntersectionNode(headA, headB);
        assertThat(result, sameInstance(headA.next));

        headA.next.next = new ListNode(5);
        result = solution.getIntersectionNode(headA, headB);
        assertThat(result, sameInstance(headA.next));

        ListNode newNode = new ListNode(0);
        newNode.next = headB;
        headB = newNode;
        result = solution.getIntersectionNode(headA, headB);
        assertThat(result, sameInstance(headA.next));

    }
}
