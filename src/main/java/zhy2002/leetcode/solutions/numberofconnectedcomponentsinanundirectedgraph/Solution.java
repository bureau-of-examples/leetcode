package zhy2002.leetcode.solutions.numberofconnectedcomponentsinanundirectedgraph;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * Example 1:
 * 0          3
 * |          |
 * 1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * <p>
 * Example 2:
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * <p>
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Solution {

    //Union find algorithm: start from a forest and use edges[] to merge trees together. In the end we calculate number of roots.
    //define parent[i] as element i is connected to element parent[i]. Or should I call it connectedTo[i]..
    //Note in parent array we never have loops because we cannot get loops by setting one root as a child of another.
    public int countComponents(int n, int[][] edges) {

        int[] parent = new int[n];
        Arrays.fill(parent, -1);  //all elements are roots

        //form components
        for (int[] edge : edges) {
            int leftParent = findRoot(parent, edge[0]);
            int rightParent = findRoot(parent, edge[1]);

            if (leftParent != rightParent) {
                parent[leftParent] = rightParent;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    public int findRoot(int[] parent, int node) {
        if (parent[node] == -1)
            return node;

        return findRoot(parent, parent[node]);
    }
}
