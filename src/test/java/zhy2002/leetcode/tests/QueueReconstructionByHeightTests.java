package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/#/description
 */
public class QueueReconstructionByHeightTests {

    @Test
    public void test() {
//        int[][] data = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
//        Solution solution = new Solution();
//        assertThat(solution, equalTo(solution.reconstructQueue(data)));
    }

    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (p1, p2) -> {
                int diff = p2[0] - p1[0];
                if (diff == 0) {
                    diff = p1[1] - p2[1];
                }
                return diff;
            });

            List<int[]> queue = new ArrayList<>();
            for (int[] person : people) {
                queue.add(person[1], person);
            }
            return queue.toArray(new int[queue.size()][]);
        }
    }
}
