package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.sudokusolver.MultipleSolution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SudokuSolverTests {

    public class Solution2 {
        private int[] rows;
        private int[] cols;
        private int[][] blocks;

        public void solveSudoku(char[][] board) {
            rows = new int[9];
            cols = new int[9];
            blocks = new int[3][3];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.' && !setCell(board, i, j))
                        return;
                }
            }
            hasSolution(board, 0, 0);
        }

        private boolean setCell(char[][] board, int i, int j) {
            int bit = 1 << (board[i][j] - '0');
            if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (blocks[i / 3][j / 3] & bit) != 0)
                return false;
            rows[i] |= bit;
            cols[j] |= bit;
            blocks[i / 3][j / 3] |= bit;
            return true;
        }

        private boolean hasSolution(char[][] board, int rowStart, int colStart) {
            for (int i = rowStart; i < 9; i++) {
                for (int j = (i == rowStart ? colStart : 0); j < 9; j++) {
                    if (board[i][j] != '.')
                        continue;
                    for (int k = 1; k <= 9; k++) {
                        if (updateCell(board, i, j, k)) {
                            if (hasSolution(board, i, j + 1))
                                return true;
                            clearCell(board, i, j, k);
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean updateCell(char[][] board, int i, int j, int k) {
            board[i][j] = (char) (k + '0');
            if (setCell(board, i, j))
                return true;
            board[i][j] = '.';
            return false;
        }

        private void clearCell(char[][] board, int i, int j, int k) {
            board[i][j] = '.';
            int bit = ~(1 << k);
            rows[i] &= bit;
            cols[j] &= bit;
            blocks[i / 3][j / 3] &= bit;
        }

    }

    @Test
    public void basicTest() {
        //"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
        Solution2 solution = new Solution2();
        char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };

        solution.solveSudoku(board);
        String result = Utils.charMatrixToString(board);
        assertEquals("519748632 783652419 426139875 357986241 264317598 198524367 975863124 832491756 641275983", result);

    }

    @Test
    public void multipleTest() {
        MultipleSolution multipleSolution = new MultipleSolution();
        char[][] board0 = {
                {'.', '.', '5', '.', '.', '6', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '8', '1', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '6', '3'},
                {'6', '.', '3', '1', '.', '4', '.', '.', '.'},
                {'9', '.', '.', '6', '.', '.', '.', '.', '7'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '9', '.', '.', '.'},
                {'.', '.', '.', '3', '.', '.', '.', '.', '.'}
        };
        char[][] board1 = {
                {'2', '5', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '9', '8', '.', '1', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '3', '9'},
                {'9', '.', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '6', '.', '4', '.', '.', '.', '7', '.'},
                {'.', '.', '4', '.', '.', '8', '6', '.', '1'},
                {'.', '.', '2', '6', '.', '7', '.', '.', '5'},
                {'.', '.', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'}
        };
        char[][] board2 = {
                {'.', '.', '.', '.', '6', '2', '.', '9', '3'},
                {'.', '.', '.', '.', '.', '.', '6', '.', '.'},
                {'9', '.', '2', '7', '.', '.', '.', '.', '.'},
                {'4', '1', '3', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '1', '.', '.'},
                {'.', '.', '.', '1', '.', '3', '8', '.', '6'},
                {'.', '.', '.', '.', '7', '1', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '4', '9', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'}
        };
        char[][] board3 = {
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'4', '.', '8', '.', '.', '.', '7', '.', '.'},
                {'3', '.', '.', '6', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '2', '.', '5', '4', '.', '8'},
                {'8', '7', '.', '1', '.', '.', '.', '.', '3'},
                {'.', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '4', '.', '9', '.', '.', '3', '.', '7'},
                {'.', '.', '.', '7', '.', '.', '6', '.', '.'},
                {'.', '.', '.', '.', '5', '.', '.', '.', '.'}
        };
        char[][] board4 = {
                {'.', '.', '.', '4', '.', '5', '.', '.', '3'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '8', '2'},
                {'.', '9', '1', '.', '8', '7', '6', '4', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '9', '.', '.', '.'},
                {'4', '.', '.', '.', '3', '.', '.', '9', '8'},
                {'.', '5', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '1', '.', '6', '.', '.', '.', '5', '.'}
        };

        boolean solvable = multipleSolution.solveMultiple(board0, board1, board2, board3, board4);
        assertTrue(solvable);
    }
}
