package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.removelinkedlistelements.Solution;

import static org.junit.Assert.*;

public class RemoveLinkedListElementsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals("", Utils.linkedListToString(solution.removeElements(Utils.createLinkedList(1, 1, 1, 1), 1)));
        assertEquals("2 3", Utils.linkedListToString(solution.removeElements(Utils.createLinkedList(1, 1, 1, 1, 2, 3), 1)));
        assertEquals("6 2 3", Utils.linkedListToString(solution.removeElements(Utils.createLinkedList(6, 1, 1, 1, 1, 2, 3), 1)));
        assertEquals("6 1 1 1 1 2", Utils.linkedListToString(solution.removeElements(Utils.createLinkedList(6, 1, 1, 1, 1, 2, 3), 3)));
    }
}
