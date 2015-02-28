package zhy2002.leetcode.solutions.nqueensii;

/**
 * https://oj.leetcode.com/problems/n-queens-ii/
 */
public class Solution {

    private static class Column {

        public int number;
        public Column next;

        public Column(int columnNumber){this.number = columnNumber;}
    }

    private int size;
    private int sum;
    private Column[] rowCol;
    private Column columnHead;
    private Column columnTail;

    public int totalNQueens(int n) {

        //initialization
        size = n;
        sum = 0;
        rowCol = new Column[n];
        columnHead = new Column(-1);
        Column prev = columnHead;
        for(int i=0; i<n; i++){
            prev.next = new Column(i);
            prev = prev.next;
        }
        columnTail = prev;

        findSolutions(0);
        return sum;
    }

    //if all rows are filled the return, otherwise try the remaining columns for this row.
    private void findSolutions(int row) {
        if(row == size){
            sum++;
            return;
        }

        int remainingColumnCount = size - row;
        for(int r=0;r<remainingColumnCount; r++){
            int nextColumnNumber = columnHead.next.number;
            for(int i=0; i<row; i++){
                if(row - i == Math.abs(rowCol[i].number - nextColumnNumber)){//attached diagonally when forming a square where the two cells are diagonal corners
                    nextColumnNumber = -1;
                    break;
                }
            }

            rowCol[row] = columnHead.next;
            columnHead.next = rowCol[row].next;
            rowCol[row].next = null;
            if(rowCol[row] == columnTail){//fetched the last one
                columnTail = columnHead;
            }
            if(nextColumnNumber != -1)
                findSolutions(row + 1);

            columnTail.next = rowCol[row];
            columnTail = columnTail.next;
            rowCol[row] = null;
        }
    }
}
