package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.isomorphicstrings.Solution;
import static org.junit.Assert.*;

public class IsomorphicStringsTests {

    @Test
    public void basicTest(){
       Solution solution = new Solution();
        assertTrue(solution.isIsomorphic("ab", "ca"));
        assertFalse(solution.isIsomorphic("aa", "ca"));
        assertTrue(solution.isIsomorphic("egg", "add"));
        assertFalse(solution.isIsomorphic("foo", "bar"));
        assertTrue(solution.isIsomorphic("paper", "title"));
        assertTrue(solution.isIsomorphic("abaaba", "ceccec"));
        assertFalse(solution.isIsomorphic("abaaba", "ceccce"));
        assertFalse(solution.isIsomorphic("abaaba", "ceccdc"));
    }
}
