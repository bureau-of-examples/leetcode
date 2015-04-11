package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.reverselinkedlistii.Solution;
import static org.junit.Assert.*;

public class ReverseLinkedListIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("4 3 2 1", Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1,2,3,4), 1, 4)));
        assertEquals("2 1 3 4", Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1,2,3,4), 1, 2)));
        assertEquals("1", Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1), 1, 1)));
        assertEquals("1 2 5 4 3", Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1,2,3,4,5), 3, 5)));
        assertEquals("1 2 5 4 3 6", Utils.linkedListToString(solution.reverseBetween(Utils.createLinkedList(1,2,3,4,5,6), 3, 5)));
    }
}
