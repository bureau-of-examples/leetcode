package zhy2002.leetcode.additional.sudoku;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/is-sudoku-valid/0
 */
public class SudokuSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt();
        while (nTests-- > 0) {
            int[][] board = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            if (canSolve(board)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static int[] rows;
    private static int[] cols;
    private static int[][] blocks;

    private static boolean canSolve(int[][] board) {
        rows = new int[9];
        cols = new int[9];
        blocks = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0 && !setCell(board, i, j)) //give board is invalid
                    return false;
            }
        }
        return hasSolution(board, 0, 0);
    }

    private static boolean setCell(int[][] board, int i, int j) {
        int bit = 1 << board[i][j];
        if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (blocks[i / 3][j / 3] & bit) != 0)
            return false;
        rows[i] |= bit;
        cols[j] |= bit;
        blocks[i / 3][j / 3] |= bit;
        return true;
    }

    private static boolean hasSolution(int[][] board, int rowStart, int colStart) {
        for (int i = rowStart; i < 9; i++) {
            for (int j = (i == rowStart ? colStart : 0); j < 9; j++) {
                if (board[i][j] != 0)
                    continue;
                for (int k = 1; k <= 9; k++) {
                    if (updateCell(board, i, j, k)) {
                        if(hasSolution(board, i, j + 1))
                            return true;
                        clearCell(board, i, j, k);
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean updateCell(int[][] board, int i, int j, int k) {
        board[i][j] = k;
        if (setCell(board, i, j))
            return true;
        board[i][j] = 0;
        return false;
    }

    private static void clearCell(int[][] board, int i, int j, int k) {
        board[i][j] = 0;
        int bit = ~(1 << k);
        rows[i] &= bit;
        cols[j] &= bit;
        blocks[i / 3][j / 3] &= bit;
    }
}
