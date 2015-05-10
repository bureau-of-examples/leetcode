package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.wordbreak.Solution;
import static org.junit.Assert.*;

import java.util.HashSet;

public class WordBreakTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        HashSet<String> words = new HashSet<String>();
        words.add("destination");
        words.add("section");
        words.add("second");
        words.add("condition");
        words.add("product");
        words.add("production");
        words.add("programcree");
        words.add("program");
        words.add("creek");
        assertEquals(true,solution.wordBreak("", words));
        assertEquals(true,solution.wordBreak("destinationsection", words));
        assertEquals(true,solution.wordBreak("productcondition", words));
        assertEquals(true,solution.wordBreak("productproduction", words));
        assertEquals(true,solution.wordBreak("productproduct", words));
        assertEquals(false,solution.wordBreak("producttype", words));
        assertEquals(true,solution.wordBreak("programcreek", words));

    }
}
