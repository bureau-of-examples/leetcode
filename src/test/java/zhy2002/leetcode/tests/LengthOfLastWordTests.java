package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.lengthoflastword.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class LengthOfLastWordTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(4, solution.lengthOfLastWord("aA efd abcT   "));
        assertEquals(1, solution.lengthOfLastWord("aA efd b"));
        assertEquals(3, solution.lengthOfLastWord("abc"));
        assertEquals(3, solution.lengthOfLastWord("   abc"));
    }
}
