package zhy2002.leetcode.solutions.designtictactoe;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 * <p>
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * You may assume the following rules:
 * <p>
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * <p>
 * Example:
 * <p>
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * <p>
 * TicTacToe toe = new TicTacToe(3);
 * <p>
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 * <p>
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 * <p>
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 * <p>
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 * <p>
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 * <p>
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 * <p>
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * <p>
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 */
public class TicTacToe {

    private int[] rowCounters;
    private int[] colCounters;
    private int diagCounter1;
    private int diagCounter2;
    private int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        rowCounters = new int[n];
        colCounters = new int[n];
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int playerDelta = player == 1 ? 1 : -1;
        rowCounters[row] += playerDelta;
        if (rowCounters[row] == n)
            return 1;
        if (rowCounters[row] == -n)
            return 2;
        colCounters[col] += playerDelta;
        if (colCounters[col] == n)
            return 1;
        if (colCounters[col] == -n)
            return 2;
        if (row == col) {
            diagCounter1 += playerDelta;
            if (diagCounter1 == n)
                return 1;
            if (diagCounter1 == -n)
                return 2;
        }
        if (row + col == n - 1) {
            diagCounter2 += playerDelta;
            if (diagCounter2 == n)
                return 1;
            if (diagCounter2 == -n)
                return 2;
        }

        return 0;
    }
}
