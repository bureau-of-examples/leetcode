package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.searcha2dmatrixii.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchA2DMatrixIITests {

    @Test
    public void dropRowOrColumnTest() {
        basicTest(new DropRowOrColumnSolution());
    }

    @Test
    public void binaryPartitionTest(){
       basicTest(new BinaryPartitionSolution());
    }

    private void basicTest(Solution solution) {

        int[][] matrix = {
                {10,20,30,40},
                {50,55,56,80},
                {71,80,89,99},
        };

        assertThat(solution.searchMatrix(matrix, 99), equalTo(true));
        assertThat(solution.searchMatrix(matrix, 56), equalTo(true));
        assertThat(solution.searchMatrix(matrix, 10), equalTo(true));
        assertThat(solution.searchMatrix(matrix, 80), equalTo(true));
        assertThat(solution.searchMatrix(matrix, 5), equalTo(false));
        assertThat(solution.searchMatrix(matrix, 100), equalTo(false));
        assertThat(solution.searchMatrix(matrix, 53), equalTo(false));
        assertThat(solution.searchMatrix(matrix, 31), equalTo(false));

        int[][] matrix2 = {
                {20, 30, 40},
                {21, 33, 45},
                {30, 39, 76},
                {41, 44, 85}
        };
        assertThat(solution.searchMatrix(matrix2, 20), equalTo(true));
        assertThat(solution.searchMatrix(matrix2, 30), equalTo(true));
        assertThat(solution.searchMatrix(matrix2, 76), equalTo(true));
        assertThat(solution.searchMatrix(matrix2, 44), equalTo(true));
        assertThat(solution.searchMatrix(matrix2, 41), equalTo(true));
        assertThat(solution.searchMatrix(matrix2, 42), equalTo(false));
        assertThat(solution.searchMatrix(matrix2, 75), equalTo(false));
        assertThat(solution.searchMatrix(matrix2, 29), equalTo(false));
        assertThat(solution.searchMatrix(matrix2, 80), equalTo(false));
        assertThat(solution.searchMatrix(matrix2, 99), equalTo(false));
        assertThat(solution.searchMatrix(matrix2, 5), equalTo(false));
    }
}
