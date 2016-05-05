package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.sparsematrixmultiplication.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SparseMatrixMultiplicationTests {


    @Test
    public void basicTest() {

        Solution solution = new Solution();
        int[][] result = solution.multiply(Utils.stringToIntMatrix(""), Utils.stringToIntMatrix(""));
        assertThat(Utils.intMatrixToString(result), equalTo(""));

        result = solution.multiply(Utils.stringToIntMatrix("5"), Utils.stringToIntMatrix("6"));
        assertThat(Utils.intMatrixToString(result), equalTo("30"));

        result = solution.multiply(Utils.stringToIntMatrix("5 4"), Utils.stringToIntMatrix("6,2"));
        assertThat(Utils.intMatrixToString(result), equalTo("38"));

        result = solution.multiply(Utils.stringToIntMatrix("1 0 0,-1 0 3"), Utils.stringToIntMatrix("7 0 0,0 0 0,0 0 1"));
        assertThat(Utils.intMatrixToString(result), equalTo("7,0,0 -7,0,3")); //todo stringToIntMatrix and intMatrixToString conflicts
    }
}
