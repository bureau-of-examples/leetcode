package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.common.RandomListNode;
import zhy2002.leetcode.solutions.copylistwithrandompointer.HashMapSolution;
import zhy2002.leetcode.solutions.copylistwithrandompointer.InPlaceSolution;
import zhy2002.leetcode.solutions.copylistwithrandompointer.Solution;
import static org.junit.Assert.*;

public class CopyListWithRandomPointerTests {

    @Test
    public void hashMapBasicTest(){
        basicTest(new HashMapSolution());
    }

    @Test
    public void inPlaceBasicTest(){
        basicTest(new InPlaceSolution());
    }

    private void basicTest(Solution solution){
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);

        RandomListNode result = solution.copyRandomList(head);
        assertEquals(1, result.label);
        assertEquals(2, result.next.label);
        assertNull(result.random);
        assertNull(result.next.random);

        head.random = head;
        result = solution.copyRandomList(head);
        assertEquals(result, result.random);


    }
}
