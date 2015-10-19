package zhy2002.leetcode.solutions.nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class Solution {

    public List<String[]> solveNQueens(int n) {
        List<String[]> results = new ArrayList<>();
        int[] board = new int[n * n]; //0 -> empty, 1 -> queen, negative number k: attacked by k queens.
        solveNQueens(results, board, n, 0);
        return results;
    }

    public static void solveNQueens(List<String[]> results, int[] board, int n, int row) {

        if (row == n) {//construct solution
            String[] solution = new String[n];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i * n + j] > 0)
                        stringBuilder.append('Q');
                    else
                        stringBuilder.append('.');
                }
                solution[i] = stringBuilder.toString();
                stringBuilder.setLength(0);
            }
            results.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (board[row * n + col] == 0) {

                //mark
                mark(board, n, row, col, -1);
                board[row * n + col] = 1;

                solveNQueens(results, board, n, row + 1);

                //restore
                mark(board, n, row, col, 1);
                board[row * n + col] = 0;
            }
        }
    }

    private static void mark(int[] board, int n, int i, int j, int val) {


        for (int rowStep = -1; rowStep <= 1; rowStep++) {
            for (int colStep = -1; colStep <= 1; colStep++) {
                if (rowStep == 0 && colStep == 0)
                    continue;
                int rowK = i, colK = j;
                while (true) {
                    if (rowStep != 0) {
                        rowK += rowStep;
                        if (rowK < 0 || rowK >= n)
                            break;
                    }

                    if (colStep != 0) {
                        colK += colStep;
                        if (colK < 0 || colK >= n)
                            break;
                    }

                    board[rowK * n + colK] += val;
                }
            }
        }
    }
}
