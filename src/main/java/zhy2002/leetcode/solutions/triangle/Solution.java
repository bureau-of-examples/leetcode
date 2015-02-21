package zhy2002.leetcode.solutions.triangle;

import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 * for each row, for each cell in the row, calculate the min path from top to the cell.
 * Cell min = min(upper left cell min, upper right cell min) + cell val.
 * row i-1:     A   B   C   D
 * row i:      E  F   G   H   I
 * Cell H is only reachable from C and D.
 * Caclculation can be done using triangle.length cells because e.g. A can be overwritten when F is calculated, B can be overwritten when G is calculated...
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        //assume size of row i in triangle is i+1.
        int[] buffer = new int[triangle.size()];
        int bufferEnd = buffer.length - 1; //calculation starts from the end of buffer, moving forward by 1 cell for each row.
        buffer[bufferEnd] = triangle.get(0).get(0);
        for(int i=1; i< triangle.size(); i++){

            int rowStart = buffer.length - i - 1;
            int triangleRowStart = 0;
            for(int j=rowStart; j<buffer.length; j++){
                if(j == rowStart){
                    buffer[j] = buffer[j + 1] + triangle.get(i).get(triangleRowStart);
                } else if(j < bufferEnd){
                    buffer[j] = Math.min(buffer[j], buffer[j+1]) + triangle.get(i).get(triangleRowStart);
                } else{
                    buffer[j] = buffer[j] + triangle.get(i).get(triangleRowStart);
                }
                triangleRowStart++;
            }
        }

        int min = buffer[0];
        for(int i=1; i<buffer.length; i++){
            if(min > buffer[i])
                min = buffer[i];
        }

        return min;

    }
}
