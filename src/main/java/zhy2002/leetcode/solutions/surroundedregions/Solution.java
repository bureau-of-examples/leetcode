package zhy2002.leetcode.solutions.surroundedregions;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/surrounded-regions/
 * Flood fill non-surrounded to T.
 */
public class Solution {

    public void solve(char[][] board) {

        if (board == null || board.length <= 2 || board[0].length <= 2)
            return;

        int rowCount = board.length;
        int colCount = board[0].length;

        //mark connected component from roots
        for (int j = 0; j < colCount; j++) {
            if (board[0][j] == 'O')
                markConnected(board, 0, j);
        }

        int lastCol = colCount - 1;
        for (int i = 1; i < rowCount; i++) {
            if (board[i][lastCol] == 'O')
                markConnected(board, i, lastCol);
        }

        int lastRow = rowCount - 1;
        for (int j = lastCol - 1; j >= 0; j--) {
            if (board[lastRow][j] == 'O')
                markConnected(board, lastRow, j);
        }

        for (int i = lastRow - 1; i >= 1; i--) {
            if (board[i][0] == 'O')
                markConnected(board, i, 0);
        }

        //update T to O, O to X
        for (int i = rowCount - 1; i >= 0; i--) {
            for (int j = colCount - 1; j >= 0; j--) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    //bfs
    private static void markConnected(char[][] board, int i, int j) {

        Stack<Integer> coordinates = new Stack<>();
        coordinates.push(j);
        coordinates.push(i);

        while (!coordinates.isEmpty()) {
            i = coordinates.pop();
            j = coordinates.pop();
            board[i][j] = 'T';

            if (i > 0 && board[i - 1][j] == 'O') {//up
                coordinates.push(j);
                coordinates.push(i - 1);
            }

            if (j < board[0].length - 1 && board[i][j + 1] == 'O') {//right
                coordinates.push(j + 1);
                coordinates.push(i);
            }

            if (i < board.length - 1 && board[i + 1][j] == 'O') {//down
                coordinates.push(j);
                coordinates.push(i + 1);
            }

            if (j > 0 && board[i][j - 1] == 'O') {//left
                coordinates.push(j - 1);
                coordinates.push(i);
            }
        }
    }

    /*
    //recursive dfs - this is not good as stack can overflow for large inputs
    //the reason is in the worst case stack memory grows linearly with the number of cells.
    
    private static void markConnected(char[][] board, int i, int j) {
        board[i][j] = 'T';
        if(i > 0 && board[i-1][j] == 'O')
            markConnected(board, i-1, j);

        if(j < board[0].length - 1 && board[i][j+1] == 'O')
            markConnected(board, i, j+1);

        if(i < board.length - 1 && board[i+1][j] == 'O')
            markConnected(board, i+1, j);

        if(j > 0 && board[i][j-1] == 'O')
            markConnected(board, i, j-1);
    }
    */
}
