package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.partitionlist.Solution;
import static org.junit.Assert.*;

public class PartitionListTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("4 3 2 1 9", Utils.linkedListToString(solution.partition(Utils.createLinkedList(4,3,2,9,1), 5)));
        assertEquals("4 3 2 9 1", Utils.linkedListToString(solution.partition(Utils.createLinkedList(4,3,2,9,1), 1)));
        assertEquals("2 1 4 3 9", Utils.linkedListToString(solution.partition(Utils.createLinkedList(4,3,2,9,1), 3)));
        assertEquals("4 3 2 1 9 8 7 6 5", Utils.linkedListToString(solution.partition(Utils.createLinkedList(9,8,7,6,5,4,3,2,1), 5)));
    }
}
