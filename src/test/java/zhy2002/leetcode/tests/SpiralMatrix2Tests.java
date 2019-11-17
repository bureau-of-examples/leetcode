package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2Tests {

    @Test
    public void test() {
        List<Integer> result = spiralOrder(new int[][] {{1},{2}});
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        if (rowEnd < rowStart) {
            return result;
        }
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            for (int i = rowStart; i < rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            for (int i = colEnd; i > colStart; i--) {
                result.add(matrix[rowEnd][i]);
            }
            for (int i = rowEnd; i > rowStart; i--) {
                result.add(matrix[i][colStart]);
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }

        if (rowStart == rowEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
        } else if (colStart == colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colStart]);
            }
        }
        return result;
    }


}
