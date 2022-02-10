package cs2022.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int isLandCount = scanner.nextInt();
        int priceCount = scanner.nextInt();
        int[][] prices = new int[priceCount][3];
        for (int i = 0; i < priceCount; i++) {
            prices[i][0] = scanner.nextInt();
            prices[i][1] = scanner.nextInt();
            prices[i][2] = scanner.nextInt();
        }

        System.out.println(solve(isLandCount, prices));
    }

    // prim's min spanning tree
    private static int solve(int islandCount, int[][] prices) {
        Map<Integer, List<int[]>> edges = new HashMap<>(islandCount * 2);
        // build undirected weighted graph
        for (int[] price : prices) {
            edges.computeIfAbsent(price[0], k -> new ArrayList<>()).add(new int[] {price[1], price[2]});
            edges.computeIfAbsent(price[1], k -> new ArrayList<>()).add(new int[] {price[0], price[2]});

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[islandCount + 1];
        int v = 1;
        int result = 0;
        for (int i = 0; i < islandCount - 1; i++) {
            visited[v] = true;
            List<int[]> vEdges = edges.get(v);
            pq.addAll(vEdges);
            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                if (visited[edge[0]]) {
                    continue;
                }
                result += edge[1];
                v = edge[0];
                break;
            }
        }

        return result;
    }

}
