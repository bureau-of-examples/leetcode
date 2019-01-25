package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfDistancesInTreeTests {

    @Test
    public void test() {
        //int[] sum = sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
        int[] sum = sumOfDistancesInTree(3, new int[][]{{2, 0}, {1, 0}});
        for (int s : sum) {
            System.out.println(s);
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N <= 0) {
            return new int[0];
        }

        //build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //get count and root sum
        int[] count = new int[N];
        int[] sum = new int[N];
        postOrder(graph, 0, -1, count, sum);

        //calc descendant sum
        for (Integer child : graph.get(0)) {
            preOrder(graph, child, 0, count, sum);
        }

        return sum;
    }

    private void postOrder(Map<Integer, Set<Integer>> graph, int node, int parent, int[] count, int[] sum) {
        for (Integer child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            postOrder(graph, child, node, count, sum);
            count[node] += count[child];
            sum[node] += sum[child];
        }

        sum[node] += count[node];
        count[node]++;
    }

    private void preOrder(Map<Integer, Set<Integer>> graph, int node, int parent, int[] count, int[] sum) {
        sum[node] = sum[parent] - count[node] + (count.length - count[node]);

        for (Integer child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            preOrder(graph, child, node, count, sum);
        }
    }

}
