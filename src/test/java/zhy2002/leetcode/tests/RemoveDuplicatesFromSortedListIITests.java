package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.removeduplicatesfromsortedlistii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RemoveDuplicatesFromSortedListIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        ListNode node1 = Utils.createLinkedList(1,1,1);
        ListNode result = solution.deleteDuplicates(node1);
        assertThat(result, nullValue());

        node1 = Utils.createLinkedList(1,1,1,2,3);
        result = solution.deleteDuplicates(node1);
        assertThat(Utils.linkedListToString(result), equalTo("2 3"));

        node1 = Utils.createLinkedList(1,2,2,3,3);
        result = solution.deleteDuplicates(node1);
        assertThat(Utils.linkedListToString(result), equalTo("1"));

        node1 = Utils.createLinkedList(1,2,2,3,3,4);
        result = solution.deleteDuplicates(node1);
        assertThat(Utils.linkedListToString(result), equalTo("1 4"));

        node1 = Utils.createLinkedList(1,2,2,3,4,4,4,4,5);
        result = solution.deleteDuplicates(node1);
        assertThat(Utils.linkedListToString(result), equalTo("1 3 5"));
    }
}
