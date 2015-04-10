package zhy2002.leetcode.solutions.wordsearch;

import java.util.Stack;

/**
 * https://leetcode.com/problems/word-search/
 * Search in graph.
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            throw new IllegalArgumentException();

        if(word.length() == 0)
            return true;

        int rowCount = board.length;
        if(rowCount == 0)
            return false;

        int colCount = board[0].length;
        if(colCount == 0)
            return false;


        Stack<Object> stack = new Stack<>();
        int charIndex = 0;
        stack.push(0);
        stack.push('0'); //01234 -> 0右下左上

        while (true){
            if(charIndex == word.length())
                return true;
            char status = (Character)stack.pop();
            int cellIndex = (Integer)stack.pop();
            if(cellIndex >= rowCount * colCount)
                break;
            int i = cellIndex / colCount;
            int j = cellIndex % colCount;
            int nextCellIndex;

            switch (status){
                case '0': //to match with this
                    if(board[i][j] == word.charAt(charIndex)){
                        stack.push(cellIndex);
                        stack.push('1');
                        charIndex++;
                    } else {
                        if(!stack.isEmpty()){
                            status = (Character)stack.pop();
                            stack.push((char)(status + 1));
                        } else {
                            stack.push(cellIndex + 1);
                            stack.push('0');
                        }
                    }
                    break;
                case '1': //right
                    j++;
                    nextCellIndex = i * colCount + j;
                    if(j >= colCount || stack.contains(nextCellIndex)){
                        stack.push(cellIndex);
                        stack.push('2');
                    } else {
                        stack.push(cellIndex);
                        stack.push('1');
                        stack.push(nextCellIndex);
                        stack.push('0');
                    }
                    break;
                case '2'://down
                    i++;
                    nextCellIndex = i * colCount + j;
                    if(i >= rowCount || stack.contains(nextCellIndex)){
                        stack.push(cellIndex);
                        stack.push('3');
                    } else {
                        stack.push(cellIndex);
                        stack.push('2');
                        stack.push(nextCellIndex);
                        stack.push('0');
                    }
                    break;
                case '3'://left
                    j--;
                    nextCellIndex = i * colCount + j;
                    if(j < 0 || stack.contains(nextCellIndex)){
                        stack.push(cellIndex);
                        stack.push('4');
                    } else {
                        stack.push(cellIndex);
                        stack.push('3');
                        stack.push(nextCellIndex);
                        stack.push('0');
                    }
                    break;
                case '4': //up
                    i--;
                    nextCellIndex = i * colCount + j;
                    if(i < 0 || stack.contains(nextCellIndex)){
                        stack.push(cellIndex);
                        stack.push('5');
                    } else {
                        stack.push(cellIndex);
                        stack.push('4');
                        stack.push(nextCellIndex);
                        stack.push('0');
                    }
                    break;
                default: //matched node cannot progress
                    charIndex--;
                    if(stack.isEmpty()){
                        stack.push(cellIndex + 1);
                        stack.push('0');
                    } else {
                        status = (Character)stack.pop();
                        stack.push((char)(status + 1));
                    }
                    break;
            }
        }

        return false;
    }
}
