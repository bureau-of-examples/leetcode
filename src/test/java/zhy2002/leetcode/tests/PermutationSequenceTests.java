package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.permutationsequence.Solution;
import static org.junit.Assert.*;

public class PermutationSequenceTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("12", solution.getPermutation(2,1));
        assertEquals("21", solution.getPermutation(2,2));
        assertEquals("123", solution.getPermutation(3,1));
        assertEquals("132", solution.getPermutation(3,2));
        assertEquals("213", solution.getPermutation(3,3));
        assertEquals("321", solution.getPermutation(3,6));
    }
}
