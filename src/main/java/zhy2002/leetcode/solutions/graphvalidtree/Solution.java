package zhy2002.leetcode.solutions.graphvalidtree;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class Solution {

    /*
        1) Verify the number of edges is n - 1.
        2a) If there is a loop, the graph will not be connected. We can try to find if there are multiple groups of nodes in the graph.
        2b) But an easier way is to check if one side of an edge and the other side of an edge is in the same group when the edge is not considered.
        3) We merge two trees by pointing the parent of one root to the other root.
     */
    @SuppressWarnings("unchecked")
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1)
            return false;

        int[] parent = new int[n];
        Arrays.fill(parent, -1); //parent not found yet

        for(int[] edge : edges){
            int leftRoot = findRoot(parent, edge[0]);
            int rightRoot = findRoot(parent, edge[1]);
            if(leftRoot == rightRoot){
                return false;
            }
            parent[leftRoot] = rightRoot;
        }
        return true;
    }

    private int findRoot(int[] parent, int node){
        if(parent[node] == -1){
            return node;
        }

        return findRoot(parent, parent[node]);
    }
}
