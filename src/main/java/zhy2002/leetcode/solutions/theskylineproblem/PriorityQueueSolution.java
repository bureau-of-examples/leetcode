package zhy2002.leetcode.solutions.theskylineproblem;

import java.util.*;

/**
 * A very concise solution found at:
 * https://leetcode.com/discuss/54201/short-java-solution
 */
public class PriorityQueueSolution implements Solution {

    public List<int[]> getSkyline(int[][] buildings) {
        //all vertical edges sort by x coordinate when x is the same left edge order by height desc right edge order by height asc, left edge before right edge
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max heap of active heights (right edge not encountered)
        pq.offer(0); //level height
        int previousHeight = 0; //height of the previous skyline point
        List<int[]> result = new ArrayList<>();
        for (int[] h : height) {
            if (h[1] < 0) { //left edge
                pq.offer(-h[1]); //same height can queue multiple times
            } else {
                pq.remove(h[1]);//end a height once -> can improve this by using some hashing index and flag? e.g. pq<Pair<Height, Count>>, Multi valued map from height -> pair; remove = count--, add = count++
            }
            int currentHeight = pq.peek();
            if (previousHeight != currentHeight) { //only add a point if the current height changes
                result.add(new int[]{h[0], currentHeight});
                previousHeight = currentHeight;
            }
        }
        return result;
    }
}
