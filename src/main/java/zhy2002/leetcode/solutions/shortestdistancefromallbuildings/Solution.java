package zhy2002.leetcode.solutions.shortestdistancefromallbuildings;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * <p>
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * <p>
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * <p>
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class Solution {

    private int rowCount;
    private int colCount;
    private HashMap<Long, Integer> dist; //a map of all houses that can reach all buildings and the total

    public int shortestDistance(int[][] grid) {

        rowCount = grid.length;
        if (rowCount == 0)
            return -1;
        colCount = grid[0].length;
        if (colCount == 0)
            return -1;

        dist = new HashMap<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0) {
                    dist.put((long) i << 32 | j, 0);
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j); //calc min dist to this build from all reachable empty cells
                    if (dist.isEmpty())
                        return -1;
                }
            }
        }

        return dist.values().stream().min(Comparator.naturalOrder()).orElse(0);
    }

    private static int[][] STEPS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void bfs(int[][] grid, int i, int j) {
        HashMap<Long, Integer> neighbours = new HashMap<>(); //all empty lands reachable from this building
        Queue<Long> toBeInspected = new LinkedList<>(); //cells whose neighbours need to be inspected
        toBeInspected.add((long) i << 32 | j); //the building

        while (!toBeInspected.isEmpty()) {
            long cellKey = toBeInspected.poll();
            int neighbourDist = neighbours.getOrDefault(cellKey, 0) + 1;
            int row = (int) (cellKey >> 32);
            int col = (int) cellKey;
            for (int[] step : STEPS) {
                int neighbourRow = row + step[0];
                if (neighbourRow < 0 || neighbourRow >= rowCount)
                    continue;
                int neighbourCol = col + step[1];
                if (neighbourCol < 0 || neighbourCol >= colCount)
                    continue;
                Long neighbourKey = (long) neighbourRow << 32 | neighbourCol;
                if (grid[neighbourRow][neighbourCol] == 0 && !neighbours.containsKey(neighbourKey)) {
                    neighbours.put(neighbourKey, neighbourDist);
                    toBeInspected.add(neighbourKey);
                }
            }
        }

        Iterator<Map.Entry<Long, Integer>> iterator = dist.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Integer> entry = iterator.next();
            if (neighbours.containsKey(entry.getKey())) {
                entry.setValue(entry.getValue() + neighbours.get(entry.getKey()));
            } else {
                iterator.remove();
            }
        }
    }
}
