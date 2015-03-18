package zhy2002.leetcode.tests;

 import org.junit.Test;
 import zhy2002.leetcode.Utils;
 import zhy2002.leetcode.solutions.sudokusolver.Solution;
 import static org.junit.Assert.*;

public class SudokuSolverTests {

    @Test
    public void basicTest(){
        //"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
        Solution solution = new Solution();
        char[][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };

        solution.solveSudoku(board);
        String result = Utils.charMatrixToString(board);
        assertEquals("519748632 783652419 426139875 357986241 264317598 198524367 975863124 832491756 641275983", result);

    }
}
