package zhy2002.leetcode.tests;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/battleships-in-a-board/#/description
 */
public class BattleshipsInABoardTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        int count = solution.countBattleships(new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        });
        assertThat(count, equalTo(2));
    }

    public class Solution {
        public int countBattleships(char[][] board) {
            int count = 0;
            int rowCount = board.length;
            int colCount = board[0].length;
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (board[i][j] == 'X') {
                        count++;
                        mark(board, i, j, rowCount, colCount);
                    }
                }
            }
            return count;
        }

        private void mark(char[][] board, int i, int j, int rowCount, int colCount) {
            board[i][j] = 'x';
            for (int index = i + 1; index < rowCount; index++) {
                if (board[index][j] == 'X') {
                    board[index][j] = 'x';
                } else {
                    break;
                }
            }
            for (int index = j + 1; index < colCount; index++) {
                if (board[i][index] == 'X') {
                    board[i][index] = 'x';
                } else {
                    break;
                }
            }
        }
    }
}
