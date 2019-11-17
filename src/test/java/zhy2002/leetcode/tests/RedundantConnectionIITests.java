package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class RedundantConnectionIITests {

    @Test
    public void test() {
        int[] result = findRedundantDirectedConnection(new int[][]{{3,4}, {4,1}, {1,2}, {2,3}, {5,1}});
        System.out.println(result[0] + "," + result[1]);
    }

    private static class UnionFind {

        private int[] parent;
        private int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            for (int i=0; i<n;i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) {
                return false;
            }

            if (rank[pi] > rank[pj]) {
                parent[j] = i;
            } else if (rank[pi] < rank[pj]) {
                parent[i] = j;
            } else {
                parent[j] = i;
                rank[i]++;
            }
            return true;
        }

        private int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] badEdge = null;
        Set<Integer> toNodes = new HashSet<>();
        for (int[] edge : edges) {
            if (toNodes.contains(edge[1])) {
                badEdge = edge;
                break;
            }
            toNodes.add(edge[1]);
        }
        if (badEdge != null) {
            return connectedWithout(edges, badEdge) ? badEdge : otherEdge(edges, badEdge);
        }

        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            toNodes.add(edge[1]);
            if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return null;
    }

    private boolean connectedWithout(int[][] edges, int[] badEdge) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (edge == badEdge) {
                continue;
            }

            if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                return false;
            }
        }
        return true;
    }

    private int[] otherEdge(int[][] edges, int[] badEdge) {
        for (int[] edge : edges) {
            if (edge[1] == badEdge[1]) {
                return edge;
            }
        }
        return null;
    }
}
