package cs2022.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionD {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] parts = br.readLine().split("\\s+");
            int n = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);

            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                br.read(grid[i]);
                if (i != n - 1) {
                    br.skip(1);
                }
            }

            System.out.println(solve(n, m, grid));
        } catch (IOException ex) {
            System.err.println("exception occurred: " + ex);
            throw new RuntimeException("exception occurred: ", ex);
        }
    }

    private static int solve(int n, int m, char[][] grid) {
        // find first island
        int startX = -1, startY = -1;
        OUTER:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'x') {
                    startX = i;
                    startY = j;
                    break OUTER;
                }
            }
        }

        // mark island 1 to y and get boarder
        Deque<int[]> queue = new ArrayDeque<>(n * m);
        bfsGetBorder(n, m, grid, startX, startY, queue);

        // bfs get distance
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                if (enqueue2(n, m, grid, pos[0] + 1, pos[1], queue) ||
                        enqueue2(n, m, grid, pos[0], pos[1] + 1, queue) ||
                        enqueue2(n, m, grid, pos[0], pos[1] - 1, queue) ||
                        enqueue2(n, m, grid, pos[0] - 1, pos[1], queue)) {
                    return dist;
                }
            }
            dist++;
        }
        throw new RuntimeException("other island not found");
    }

    private static void bfsGetBorder(int n, int m, char[][] grid, int startX, int startY, Deque<int[]> borderQueue) {
        Deque<int[]> queue = new ArrayDeque<>(n * m);
        queue.add(new int[]{startX, startY});
        grid[startX][startY] = 'y';
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            enqueue(n, m, grid, pos[0] + 1, pos[1], queue, borderQueue);
            enqueue(n, m, grid, pos[0], pos[1] + 1, queue, borderQueue);
            enqueue(n, m, grid, pos[0], pos[1] - 1, queue, borderQueue);
            enqueue(n, m, grid, pos[0] - 1, pos[1], queue, borderQueue);
        }
    }

    private static void enqueue(int n, int m, char[][] grid, int x, int y, Deque<int[]> queue, Deque<int[]> borderQueue) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 'y') {
            return;
        }
        if (grid[x][y] == '.') {
            borderQueue.add(new int[]{x, y});
        } else {
            queue.add(new int[]{x, y});
        }
        grid[x][y] = 'y';
    }

    private static boolean enqueue2(int n, int m, char[][] grid, int x, int y, Deque<int[]> queue) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 'y') {
            return false;
        }
        if (grid[x][y] == 'x') {
            return true;
        }
        queue.add(new int[]{x, y});
        grid[x][y] = 'y';
        return false;
    }
}
