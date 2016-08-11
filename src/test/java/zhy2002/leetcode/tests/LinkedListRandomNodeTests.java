package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.linkedlistrandomnode.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class LinkedListRandomNodeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution(Utils.createLinkedList(1, 2, 3, 4, 5, 6, 7));
        int[] counts = new int[7];
        for (int i = 0; i < 1000; i++) {
            counts[solution.getRandom() - 1]++;
        }
        assertThat(counts, equalTo(new int[]{142, 136, 148, 149, 133, 146, 146}));
    }
}
