package zhy2002.leetcode.solutions.numberofislandsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-islands-ii/
 * <p>
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example:
 * <p>
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * <p>
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * <p>
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * <p>
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * <p>
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * <p>
 * We return the result as an array: [1, 1, 2, 3]
 * <p>
 * Challenge:
 * <p>
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class Solution {

    private static final int[][] DELTAS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //use union find
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> result = new ArrayList<>();
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1); //not added yet
        int rootCount = 0;
        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];
            int cellIndex = row * n + col;
            if (parent[cellIndex] != -1) {//processed
                continue;
            }
            parent[cellIndex] = cellIndex;
            rootCount++;
            for (int[] delta : DELTAS) {
                int neighbourRow = row + delta[0];
                int neighbourCol = col + delta[1];
                if (neighbourRow < 0 || neighbourRow >= m || neighbourCol < 0 || neighbourCol >= n)
                    continue;

                int neighbourIndex = neighbourRow * n + neighbourCol;
                if (union(parent, cellIndex, neighbourIndex)) {
                    rootCount--;
                }
            }

            result.add(rootCount);
        }
        return result;
    }

    private boolean union(int[] parent, int cellIndex, int neighbourIndex) {
        if (parent[neighbourIndex] != -1) {
            while (parent[neighbourIndex] != neighbourIndex) {
                parent[neighbourIndex] = parent[parent[neighbourIndex]];
                neighbourIndex = parent[neighbourIndex];
            }
            if (parent[cellIndex] != neighbourIndex) {

                parent[neighbourIndex] = cellIndex;
                return true;
            }
        }
        return false;
    }

}
