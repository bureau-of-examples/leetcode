package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.reverselinkedlist.Solution;

import static org.junit.Assert.*;

public class ReverseLinkedListTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("" , Utils.linkedListToString(solution.reverseList(Utils.createLinkedList())));
        assertEquals("1" , Utils.linkedListToString(solution.reverseList(Utils.createLinkedList(1))));
        assertEquals("2 1" , Utils.linkedListToString(solution.reverseList(Utils.createLinkedList(1,2))));
        assertEquals("3 2 1" , Utils.linkedListToString(solution.reverseList(Utils.createLinkedList(1,2,3))));
        assertEquals("4 3 2 1" , Utils.linkedListToString(solution.reverseList(Utils.createLinkedList(1,2,3,4))));
    }
}
