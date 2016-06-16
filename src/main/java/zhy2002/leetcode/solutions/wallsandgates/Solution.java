package zhy2002.leetcode.solutions.wallsandgates;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/walls-and-gates/
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * <p>
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * For example, given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0    -1 INF INF
 * <p>
 * After running your function, the 2D grid should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
public class Solution {

    private static class Cell {
        public int row;
        public int col;
        public int dist;

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    private static final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {


        int m = rooms.length;
        if(m == 0)
            return;
        int n = rooms[0].length;
        if(n == 0)
            return;

        LinkedList<Cell> markedCells = new LinkedList<>();
        int markedCount = 0, toMarkCount = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                switch (rooms[i][j]) {
                    case 0:
                        markedCells.addLast(new Cell(i, j, 0));
                        toMarkCount++;
                        markedCount++;
                        break;
                    case INF:
                        toMarkCount++;
                        break;
                }
            }
        }

        while (markedCount < toMarkCount && !markedCells.isEmpty()) {
            Cell cell = markedCells.removeFirst();
            //up
            int row = cell.row - 1;
            int col = cell.col;
            if(row >= 0 && rooms[row][col] == INF) {
                rooms[row][col] = cell.dist + 1;
                markedCount++;
                markedCells.addLast(new Cell(row, col, cell.dist + 1));
            }

            //down
            row = cell.row + 1;
            col = cell.col;
            if(row < m && rooms[row][col] == INF) {
                rooms[row][col] = cell.dist + 1;
                markedCount++;
                markedCells.addLast(new Cell(row, col, cell.dist + 1));
            }

            //left
            row = cell.row;
            col = cell.col - 1;
            if(col >= 0 && rooms[row][col] == INF) {
                rooms[row][col] = cell.dist + 1;
                markedCount++;
                markedCells.addLast(new Cell(row, col, cell.dist + 1));
            }

            //right
            row = cell.row;
            col = cell.col + 1;
            if(col < n && rooms[row][col] == INF) {
                rooms[row][col] = cell.dist + 1;
                markedCount++;
                markedCells.addLast(new Cell(row, col, cell.dist + 1));
            }

        }
    }
}
