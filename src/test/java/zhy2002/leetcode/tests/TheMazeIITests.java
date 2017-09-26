package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/the-maze-ii/description/
 */
public class TheMazeIITests {

    class Solution {

        private class Position {
            int x;
            int y;
            int dist;

            public Position(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.dist = distance;
            }
        }

        private final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private int[][] maze;
        private boolean[][] visited;
        private int m, n;
        private int minDist;

        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            m = maze.length;
            n = maze[0].length;
            this.maze = maze;
            visited = new boolean[m][n];
            minDist = -1;

            bfs(start, destination);
            return minDist;
        }

        private void bfs(int[] start, int[] destination) {
            PriorityQueue<Position> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
            queue.add(new Position(start[0], start[1], 0));
            while (!queue.isEmpty()) {
                Position pos = queue.poll();
                if (minDist != -1 && minDist < pos.dist)//prune
                    continue;

                if (pos.x == destination[0] && pos.y == destination[1]) { //reach destination
                    minDist = pos.dist;
                    continue;
                }

                visited[pos.x][pos.y] = true;
                for (int[] dir : directions) {
                    int x = pos.x;
                    int y = pos.y;
                    int dist = pos.dist;
                    while (isSpace(x + dir[0], y + dir[1])) {
                        x += dir[0];
                        y += dir[1];
                        dist++;
                    }
                    if (isSpace(x, y) && !visited[x][y]) {
                        queue.add(new Position(x, y, dist));
                    }
                }
            }
        }

        private boolean isSpace(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int result = solution.shortestDistance(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4});
        assertThat(result, equalTo(12));
    }

}
