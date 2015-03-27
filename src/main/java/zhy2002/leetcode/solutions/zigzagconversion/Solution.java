package zhy2002.leetcode.solutions.zigzagconversion;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * Set up buffer to store the result. Then work out where to get the characters one by one.
 * A cycle is:
 * X   Y
 * X  XY  Y
 * X X Y Y
 * X   Y
 * The grid is sparse.
 */
public class Solution {

    public String convert(String s, int nRows) {
        if (nRows == 1 || nRows >= s.length())
            return s;

        int colBlockWidth = nRows - 1;//number of columns per cycle
        int colBlockSize = 2 * nRows - 2;
        int row = 0, col = 0;//from top to bottom, left to right, the grid representation of the source character for result position i.
        char[] result = new char[s.length()];
        for (int i = 0; i < result.length; i++) { //fill each char in result

            //work out where to get the char from
            int sIndex = colBlockSize * (col / colBlockWidth);//source index
            int remainingCol = col % colBlockWidth;
            if (remainingCol == 0) {
                sIndex += row;
            } else {
                sIndex += nRows;
                sIndex += remainingCol - 1;
            }

            //goto next row
            if (sIndex >= s.length()) {
                row++;
                col = 0;
                i--;//redo this
                continue;
            }

            result[i] = s.charAt(sIndex);

            //goto next col
            if (row == 0 || row == colBlockWidth)
                col += colBlockWidth;
            else {
                if (col % colBlockWidth == 0)
                    col += colBlockWidth - row;
                else
                    col += row;
            }
        }

        return new String(result);
    }
}
