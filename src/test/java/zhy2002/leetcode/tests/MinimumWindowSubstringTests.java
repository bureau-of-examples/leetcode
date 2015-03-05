package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.minimumwindowsubstring.Solution;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("", solution.minWindow("",""));
        assertEquals("at", solution.minWindow("sat","ta"));
        assertEquals("star", solution.minWindow("start","star"));
        assertEquals("bsbsb", solution.minWindow("sbsbsb","bbb"));
        assertEquals("stas", solution.minWindow("badestasf","sas"));
        assertEquals("", solution.minWindow("AABAaAabA","BAAB"));
        assertEquals("baAabbB", solution.minWindow("baAabbBBB","Bbbb"));
        assertEquals("", solution.minWindow("ae","ax"));
        assertEquals("aabcabbcab", solution.minWindow("aacbaccccaabcabbcab","bcbbacaaab"));

    }


}
