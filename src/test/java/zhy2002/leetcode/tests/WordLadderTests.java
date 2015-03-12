package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.wordladder.Solution;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordLadderTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        Set<String> dict = new HashSet<>();

        assertEquals(1, solution.ladderLength("","", dict));

        dict.add("test");
        dict.add("tese");
        assertEquals(2, solution.ladderLength("test","tese", dict));

        dict.add("bese");
        assertEquals(3, solution.ladderLength("test","bese", dict));

        dict.add("abcd");
        assertEquals(0, solution.ladderLength("test","abcd", dict));
    }
}
