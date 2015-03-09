package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.scramblestring.Solution;

import static org.junit.Assert.*;


public class ScrambleStringTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertTrue(solution.isScramble("",""));
        assertTrue(solution.isScramble("a","a"));
        assertTrue(solution.isScramble("ba","ab"));
        assertTrue(solution.isScramble("abc","cba"));
        assertTrue(solution.isScramble("aaa","aaa"));
        assertTrue(solution.isScramble("abcd","cdba"));
        assertTrue(solution.isScramble("abcd","dabc"));
        assertTrue(solution.isScramble("abcd","dbac"));
        assertFalse(solution.isScramble("a","b"));
        assertFalse(solution.isScramble("great", "agetr"));
        assertTrue(solution.isScramble("abcd", "bcad"));
        assertFalse(solution.isScramble("abcd", "bdac"));
        assertTrue(solution.isScramble("bcabcbbbbabaacbaa", "cabaacbaabbacbbbb"));
        assertFalse(solution.isScramble("ymjmfxshglxwrrgufcvvzjuietjzzz", "fxczujvmwizrzgxgjmvzelyjthusrf"));

    }
}
