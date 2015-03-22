package zhy2002.leetcode.solutions.sudokusolver;


import java.util.*;

public class AllSolution {


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

    private List<char[][]> solutions;

    public List<char[][]> solveSudoku(char[][] board) {
        solutions = new ArrayList<>();
        short[] rowOptions = new short[board.length];
        short[] colOptions = new short[board[0].length];
        short[] blockOptions = new short[board.length * board[0].length / 9];
        Arrays.fill(rowOptions, (short) 0x1FF);//9 1s
        Arrays.fill(colOptions, (short) 0x1FF);
        Arrays.fill(blockOptions, (short) 0x1FF);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int mask = ~(1 << (board[i][j] - '1'));
                    rowOptions[i] &= mask;
                    colOptions[j] &= mask;
                    blockOptions[board[i].length / 3 * (i / 3) + j / 3] &= mask;
                }
            }
        }

        short[][] cellOptions = new short[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    cellOptions[i][j] = (short) (rowOptions[i] & colOptions[j] & blockOptions[board[i].length / 3 * (i / 3) + j / 3]);
                else
                    cellOptions[i][j] = -1;//is not empty
            }
        }

        fillBoard(cellOptions, board, 0, 0);
        return solutions;
    }

    private boolean fillBoard(short[][] cellOptions, char[][] board, int i, int j) {
        while (true){ //find next legal position
            if(j >= board[i].length){
                j = 0;
                i++;
            }
            if(i>=board.length){
                char[][] solution = new char[9][9];
                for(int r=0 ;r<9; r++){
                    for(int c=0; c<9; c++){
                        solution[r][c] = board[r][c];
                    }
                }
                solutions.add(solution);
                return false;//enumerate all solutions is expensive - 9^81 * a
            }


            if(cellOptions[i][j] == -1)
                j++;
            else
                break;
        }

        int options = cellOptions[i][j];
        while (options != 0){
            int option = options & ~(options - 1);
            options &= ~option;
            board[i][j] = bitMap.get(option);
            if(!isValid(board, i, j)){
                continue;
            }
            if(fillBoard(cellOptions, board, i, j + 1))
                return true;
        }
        board[i][j] = '.';
        return false;
    }

    private boolean isValid(char[][] board, int i, int j){
        int bits = 0;
        for(int c=0; c<board[i].length; c++){
            if(board[i][c] == '.')
                continue;
            int bit = 1 << board[i][c] - '1';
            if((bits & bit) != 0)
                return false;
            bits |= bit;
        }

        bits = 0;
        for(int r=0; r<board.length; r++){
            if(board[r][j] == '.')
                continue;
            int bit = 1 << board[r][j] - '1';
            if((bits & bit) != 0)
                return false;
            bits |= bit;
        }

        int blockRow = i / 3 * 3;
        int blockCol = j / 3 * 3;
        bits = 0;
        for(int r=blockRow; r<blockRow + 3; r++){
            for(int c=blockCol; c < blockCol + 3; c++){
                if(board[r][c] == '.')
                    continue;
                int bit = 1 << board[r][c] - '1';
                if((bits & bit) != 0)
                    return false;
                bits |= bit;
            }
        }
        return true;
    }
}
