package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.anagrams.Solution;

import static org.junit.Assert.*;

public class AnagramsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertEquals("", Utils.listToString(solution.anagrams(new String[]{})));
        assertEquals("", Utils.listToString(solution.anagrams(new String[]{"a", "b"})));
        assertEquals("ab ba", Utils.listToString(solution.anagrams(new String[]{"ab", "ba"})));
        assertEquals("ab ba", Utils.listToString(solution.anagrams(new String[]{"ab", "ba", "ca"})));
        assertEquals("ab ba", Utils.listToString(solution.anagrams(new String[]{"ab", "ba", "cab", "tes"})));
        assertEquals("ab ba cab cba", Utils.listToString(solution.anagrams(new String[]{"ab", "ba", "cab", "cba"})));
        assertEquals("tug gut", Utils.listToString(solution.anagrams(new String[]{"sea", "tug", "hop", "fur", "sag", "eve", "rex", "law", "pee", "eva", "bet", "zip", "lax", "cot", "who", "fax", "doc", "min", "fop", "mac", "fob", "ltd", "sec", "zap", "let", "zoe", "erg", "bad", "dix", "pay", "has", "ila", "axe", "sty", "day", "fat", "coy", "jot", "adz", "abe", "gut"})));
        assertEquals("fee fee fee eke eke", Utils.listToString(solution.anagrams(new String[]{"bog", "moe", "dan", "sit", "bur", "fee", "yam", "rob", "btu", "twa", "poe", "eke", "lyx", "foe", "sis", "ken", "dad", "pig", "row", "ark", "pyx", "eke", "van", "gay", "ins", "bop", "nub", "sol", "fie", "jar", "eye", "pat", "rev", "doc", "sen", "log", "fee", "ilk", "brr", "was", "lee", "fee", "coy", "meg", "run", "ito", "jot", "fla", "eli"})));

    }
}
