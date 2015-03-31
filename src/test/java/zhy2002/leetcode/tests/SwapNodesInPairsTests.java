package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.swapnodesinpairs.Solution;
import static org.junit.Assert.*;

public class SwapNodesInPairsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        ListNode list = Utils.createLinkedList(new int[]{1});
        ListNode result = solution.swapPairs(list);
        String str = Utils.linkedListToString(result);
        assertEquals("1", str);

        list = Utils.createLinkedList(new int[]{1,2});
        result = solution.swapPairs(list);
        str = Utils.linkedListToString(result);
        assertEquals("2 1", str);

        list = Utils.createLinkedList(new int[]{1,2, 3});
        result = solution.swapPairs(list);
        str = Utils.linkedListToString(result);
        assertEquals("2 1 3", str);

        list = Utils.createLinkedList(new int[]{1,2, 3, 4});
        result = solution.swapPairs(list);
        str = Utils.linkedListToString(result);
        assertEquals("2 1 4 3", str);

        list = Utils.createLinkedList(new int[]{1,2, 3, 4, 5});
        result = solution.swapPairs(list);
        str = Utils.linkedListToString(result);
        assertEquals("2 1 4 3 5", str);
    }
}
