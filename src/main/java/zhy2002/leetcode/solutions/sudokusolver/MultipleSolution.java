package zhy2002.leetcode.solutions.sudokusolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MultipleSolution {

    private static final Map<Integer, Character> bitMap = new HashMap<>();

    static {
        bitMap.put(1, '1');
        bitMap.put(2, '2');
        bitMap.put(4, '3');
        bitMap.put(8, '4');
        bitMap.put(16, '5');
        bitMap.put(32, '6');
        bitMap.put(64, '7');
        bitMap.put(128, '8');
        bitMap.put(256, '9');
    }

    private char[][][] boards;
    private char[][][] originals;
    private int lastFailedK;

    public boolean solveMultiple(char[][] board0, char[][] board1, char[][] board2, char[][] board3, char[][] board4) {
        this.boards = new char[][][]{board0, board1, board2, board3, board4};
        lastFailedK = 0; //todo use this variable to quickly unwind to where change is to desired
        originals = new char[4][9][9];
        for (int k = 1; k <= 4; k++) {
            copyTo(boards[k], originals[k - 1]);
        }
        return solveSudoku(board0, true);//find a solution for 0 where 1 2 3 4 could work, and then update and solve 1 2 3 4 respectively
    }

    private boolean solveSudoku(char[][] board, boolean centre) {
        short[][] cellOptions = getCellOptions(board, centre);
        if (cellOptions == null)
            return false;//unsolvable
        return fillBoard(board, centre, cellOptions, 0, 0);
    }


    private short[][] getCellOptions(char[][] board, boolean centre) {
        short[] rowOptions = new short[9];
        short[] colOptions = new short[9];
        short[] blockOptions = new short[9];
        Arrays.fill(rowOptions, (short) 0x1FF);//9 1s
        Arrays.fill(colOptions, (short) 0x1FF);
        Arrays.fill(blockOptions, (short) 0x1FF);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int mask = ~(1 << (board[i][j] - '1'));
                    rowOptions[i] &= mask;//set bit to 0
                    colOptions[j] &= mask;
                    blockOptions[3 * (i / 3) + j / 3] &= mask;
                }
            }
        }

        short[][] cellOptions = new short[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    cellOptions[i][j] = (short) (rowOptions[i] & colOptions[j] & blockOptions[3 * (i / 3) + j / 3]);
                    if (cellOptions[i][j] == 0) {
                        return null;
                    }
                } else
                    cellOptions[i][j] = -1;//is not empty
            }
        }
        if (!centre)
            return cellOptions;

        //left top row
        for (int i = 6; i <= 8; i++) {
            int mask = 0x1FF;
            for (int j = 0; j <= 5; j++) {
                char ch = boards[1][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 0; k <= 2; k++) {
                if (cellOptions[i - 6][k] != -1)
                    cellOptions[i - 6][k] &= mask;
            }
        }

        //left top col
        for (int j = 6; j <= 8; j++) {
            int mask = 0x1FF;
            for (int i = 0; i <= 5; i++) {
                char ch = boards[1][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 0; k <= 2; k++) {
                if (cellOptions[k][j - 6] != -1)
                    cellOptions[k][j - 6] &= mask;
            }
        }

        //right top row
        for (int i = 6; i <= 8; i++) {
            int mask = 0x1FF;
            for (int j = 3; j <= 8; j++) {
                char ch = boards[2][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 6; k <= 8; k++) {
                if (cellOptions[i - 6][k] != -1)
                    cellOptions[i - 6][k] &= mask;
            }
        }

        //right top col
        for (int j = 0; j <= 2; j++) {
            int mask = 0x1FF;
            for (int i = 0; i <= 5; i++) {
                char ch = boards[2][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 0; k <= 2; k++) {
                if (cellOptions[k][j + 6] != -1)
                    cellOptions[k][j + 6] &= mask;
            }
        }

        //left bottom row
        for (int i = 0; i <= 2; i++) {
            int mask = 0x1FF;
            for (int j = 0; j <= 5; j++) {
                char ch = boards[3][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 0; k <= 2; k++) {
                if (cellOptions[i + 6][k] != -1)
                    cellOptions[i + 6][k] &= mask;
            }
        }

        //left bottom col
        for (int j = 6; j <= 8; j++) {
            int mask = 0x1FF;
            for (int i = 3; i <= 8; i++) {
                char ch = boards[3][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 6; k <= 8; k++) {
                if (cellOptions[k][j - 6] != -1)
                    cellOptions[k][j - 6] &= mask;
            }
        }

        //right bottom row
        for (int i = 0; i <= 2; i++) {
            int mask = 0x1FF;
            for (int j = 3; j <= 8; j++) {
                char ch = boards[4][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 6; k <= 8; k++) {
                if (cellOptions[i + 6][k] != -1)
                    cellOptions[i + 6][k] &= mask;
            }
        }

        //right bottom col
        for (int j = 0; j <= 2; j++) {
            int mask = 0x1FF;
            for (int i = 3; i <= 8; i++) {
                char ch = boards[4][i][j];
                if (ch != '.')
                    mask &= ~(1 << (ch - '1'));
            }

            for (int k = 6; k <= 8; k++) {
                if (cellOptions[k][j + 6] != -1)
                    cellOptions[k][j + 6] &= mask;
            }
        }

        return cellOptions;
    }

    private boolean fillBoard(char[][] board, boolean centre, short[][] cellOptions, int i, int j) {
        //find next legal position
        while (true) {
            if (j >= board[i].length) {
                j = 0;
                i++;
            }
            if (i >= board.length) {//the board is finished
                if (!centre)
                    return true;

                for (int k = 4; k >= 1; k--) {
                    copyPart(k);
                    if (!solveSudoku(boards[k], false)) {
                        lastFailedK = k;
                        while (++k <= 4) {
                            copyTo(originals[k - 1], boards[k]);//restore
                        }
                        return false;
                    }
                }

                return true;
            }

            if (cellOptions[i][j] == -1)
                j++;
            else
                break;
        }

        int options = cellOptions[i][j];
        while (options != 0) {
            int option = options & ~(options - 1);
            options &= ~option;
            board[i][j] = bitMap.get(option);
            if (!isValid(board, i, j)) {
                continue;
            }
            if (fillBoard(board, centre, cellOptions, i, j + 1))
                return true;
        }
        board[i][j] = '.';
        return false;
    }

    private void copyPart(int index) {
        if (index == 1) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    boards[1][i + 6][j + 6] = boards[0][i][j];
                }
            }
        } else if (index == 2) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 6; j <= 8; j++) {
                    boards[2][i + 6][j - 6] = boards[0][i][j];
                }
            }
        } else if (index == 3) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 0; j <= 2; j++) {
                    boards[3][i - 6][j + 6] = boards[0][i][j];
                }
            }
        } else if (index == 4) {
            for (int i = 6; i <= 8; i++) {
                for (int j = 6; j <= 8; j++) {
                    boards[4][i - 6][j - 6] = boards[0][i][j];
                }
            }
        }
    }

    private static boolean isValid(char[][] board, int i, int j) {
        int bits = 0;
        for (int c = 0; c < board[i].length; c++) {
            if (board[i][c] == '.')
                continue;
            int bit = 1 << board[i][c] - '1';
            if ((bits & bit) != 0)
                return false;
            bits |= bit;
        }

        bits = 0;
        for (int r = 0; r < board.length; r++) {
            if (board[r][j] == '.')
                continue;
            int bit = 1 << board[r][j] - '1';
            if ((bits & bit) != 0)
                return false;
            bits |= bit;
        }

        int blockRow = i / 3 * 3;
        int blockCol = j / 3 * 3;
        bits = 0;
        for (int r = blockRow; r < blockRow + 3; r++) {
            for (int c = blockCol; c < blockCol + 3; c++) {
                if (board[r][c] == '.')
                    continue;
                int bit = 1 << board[r][c] - '1';
                if ((bits & bit) != 0)
                    return false;
                bits |= bit;
            }
        }
        return true;
    }

    private static char[][] copyTo(char[][] board, char[][] newBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
}
