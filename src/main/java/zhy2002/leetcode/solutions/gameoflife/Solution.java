package zhy2002.leetcode.solutions.gameoflife;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class Solution {

    /**
     * Since the state only take one bit, we can use the other bits to store information.
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0)
            return;
        int n = board[0].length;
        if (n == 0)
            return;

        //get live neighbour count
        for (int i = 0; i <m; i++) {
            for(int j=0; j<n; j++) {
                int liveCount = 0;
                for(int deltaI = -1; deltaI <= 1; deltaI++) {
                    int neighbourI = i + deltaI;
                    if(neighbourI < 0 || neighbourI >= m)
                        continue;
                    for(int deltaJ = -1; deltaJ <= 1; deltaJ++) {
                        if(deltaI == 0 && deltaJ == 0)
                            continue;
                        int neighbourJ = j + deltaJ;
                        if(neighbourJ < 0 || neighbourJ >= n)
                            continue;
                        if((board[neighbourI][neighbourJ] & 0x1) == 1){
                            liveCount++;
                        }
                    }
                }
                board[i][j] |= liveCount << 1;
            }
        }

        //update status
        for(int i = 0; i<m; i++) {
            for(int j=0; j<n;j++) {
                int liveCount = board[i][j] >>> 1;
                if((board[i][j] & 1) == 1) {
                    board[i][j] = liveCount == 2 || liveCount == 3 ? 1 : 0;
                } else {
                    board[i][j] = liveCount == 3 ? 1 : 0;
                }

            }
        }
    }
}
