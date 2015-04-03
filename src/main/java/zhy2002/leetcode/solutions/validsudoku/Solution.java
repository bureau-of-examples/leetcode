package zhy2002.leetcode.solutions.validsudoku;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * Check each row, column and block respectively.
 * Use an array to mark if a number has been encountered.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[] flags = new boolean[9];
        //row
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0' - 1;
                if(flags[num])
                    return false;
                flags[num] = true;
            }
            Arrays.fill(flags, false);
        }

        //col
        for(int j=0; j<9; j++){
            for(int i=0; i<9; i++){
                if(board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0' - 1;
                if(flags[num])
                    return false;
                flags[num] = true;
            }
            Arrays.fill(flags, false);
        }

        //block
        for(int rowStart = 0; rowStart < 9; rowStart += 3){
            for(int colStart=0; colStart<9; colStart+=3){
                for(int i=rowStart; i < rowStart + 3; i++){
                    for(int j=colStart; j < colStart + 3; j++){
                        if(board[i][j] == '.')
                            continue;
                        int num = board[i][j] - '0' - 1;
                        if(flags[num])
                            return false;
                        flags[num] = true;
                    }
                }
                Arrays.fill(flags, false);
            }
        }

        return true;
    }
}
