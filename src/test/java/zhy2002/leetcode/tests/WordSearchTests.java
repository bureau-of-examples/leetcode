package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.wordsearch.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordSearchTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        char[][] mat = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        assertEquals(true, solution.exist(mat, "ABCCED"));
        assertEquals(true, solution.exist(mat, "SEE"));
        assertEquals(false, solution.exist(mat, "ABCB"));
        assertEquals(true, solution.exist(mat, "ESEE"));
    }
}
