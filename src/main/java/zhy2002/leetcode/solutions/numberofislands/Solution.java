package zhy2002.leetcode.solutions.numberofislands;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Use bfs to count connected blocks of 1.
 */
public class Solution {

    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;
        int n = grid.length;
        if (grid[0].length == 0)
            return 0;
        int m = grid[0].length;

        boolean[][] flags = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '1' || flags[i][j])
                    continue;

                bfs(grid, n, m, i, j, flags);   //avoid stack overflow
                count++;
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int n, int m, int i, int j, boolean[][] flags) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        queue.add(j);
        flags[i][j] = true;

        do {
            int r = queue.poll();
            int c = queue.poll();

            int rNext = r - 1;
            int cNext = c;
            if (rNext >= 0 && grid[rNext][cNext] == '1' && !flags[rNext][cNext]) {
                queue.add(rNext);
                queue.add(cNext);
                flags[rNext][cNext] = true;
            }

            rNext = r;
            cNext = c - 1;
            if (cNext >= 0 && grid[rNext][cNext] == '1' && !flags[rNext][cNext]) {
                queue.add(rNext);
                queue.add(cNext);
                flags[rNext][cNext] = true;
            }

            rNext = r + 1;
            cNext = c;
            if (rNext < n && grid[rNext][cNext] == '1' && !flags[rNext][cNext]) {
                queue.add(rNext);
                queue.add(cNext);
                flags[rNext][cNext] = true;
            }

            rNext = r;
            cNext = c + 1;
            if (cNext < m && grid[rNext][cNext] == '1' && !flags[rNext][cNext]) {
                queue.add(rNext);
                queue.add(cNext);
                flags[rNext][cNext] = true;
            }

        } while (!queue.isEmpty());
    }

}
