package cs2022.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionF {

    private static final long DIFF_DELTA = 1000000000000L;

    public static void main(String[] args) {
        int[] health = null;
        int[] taste = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int restaurantCount = Integer.parseInt(br.readLine());
            health = new int[restaurantCount];
            taste = new int[restaurantCount];
            String[] numbers = br.readLine().split("\\s+");
            for (int i = 0; i < restaurantCount; i++) {
                health[i] = Integer.parseInt(numbers[i]);
            }
            numbers = br.readLine().split("\\s+");
            for (int i = 0; i < restaurantCount; i++) {
                taste[i] = Integer.parseInt(numbers[i]);
            }
            System.out.println(solve(restaurantCount, health, taste));
        } catch (Throwable ex) {
            System.err.println("Exception thrown: " + ex);
            System.err.println(Arrays.toString(health));
            System.err.println(Arrays.toString(taste));
            throw new RuntimeException(ex);
        }
    }

    private static int solve(int restaurantCount, int[] health, int[] taste) {
        // can go from A to B iff their h + t or h - t equals

        // first compute all groups
        Map<Long, Set<Long>> groupMap = new HashMap<>();
        for (int i = 0; i < restaurantCount; i++) {
            long sum = health[i] + taste[i];
            groupMap.put(sum, new HashSet<>());
            long diff = health[i] - taste[i] + DIFF_DELTA;
            groupMap.put(diff, new HashSet<>());
        }

        // set up edges between all groups
        for (int i = 0; i < restaurantCount; i++) {
            long sum = health[i] + taste[i];
            long diff = health[i] - taste[i] + DIFF_DELTA;
            groupMap.get(sum).add(diff);
            groupMap.get(diff).add(sum);
        }

        // bfs search target
        long srcSum = health[0] + taste[0];
        long srcDiff = health[0] - taste[0] + DIFF_DELTA;
        long destSum = health[restaurantCount - 1] + taste[restaurantCount - 1];
        long destDiff = health[restaurantCount - 1] - taste[restaurantCount - 1] + DIFF_DELTA;
        if (srcSum == destSum || srcDiff == destDiff) {
            return 1;
        }
        Deque<Long> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        queue.add(srcSum);
        visited.add(srcSum);
        queue.add(srcDiff);
        visited.add(srcDiff);

        int dist = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Long g = queue.poll();
                for (Long next : groupMap.get(g)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next == destSum || next == destDiff) {
                        return dist;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
            dist++;
        }
        return -1;
    }
}
