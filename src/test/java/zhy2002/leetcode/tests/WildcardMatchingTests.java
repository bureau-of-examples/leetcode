package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.wildcardmatching.Solution;
import static org.junit.Assert.*;

public class WildcardMatchingTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertTrue(solution.isMatch("", ""));
        assertTrue(solution.isMatch("a", "*"));
        assertTrue(solution.isMatch("a", "a*"));
        assertTrue(solution.isMatch("aaa", "*"));
        assertFalse(solution.isMatch("aa", "aaa"));
        assertTrue(solution.isMatch("baaa", "b*"));
        assertTrue(solution.isMatch("baaa", "b*a"));
        assertFalse(solution.isMatch("baada", "b*ad"));
        assertTrue(solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        assertTrue(solution.isMatch("bbbaa", "?*?"));
        assertTrue(solution.isMatch("bbbaba", "*ba"));
        assertTrue(solution.isMatch("aabaaa", "aa*?*?"));
        assertTrue(solution.isMatch("aabaaa", "aa*?***?"));
        assertTrue(solution.isMatch("bababbbbabababaabbaabbaababbbbbabaabbaaabababbaaabbbababbbbaaaaaabbbbbbabaaabbbbaababbbaaabaabaaababababaaabbbbbbababbabbbbabaabbabaabbabbbbaaabaabbbaaabaaaababbbbbabbbababbbaababaaaababaaaabbbbbbaaaabbb", "b*a*b*a****b**b*ab**ab*bb*abbb****babb**a*a*b*bb***aa*bb*b***bbba*bb*aa**b*a**b**b***a*bbbaa*bb***b*"));
        assertFalse(solution.isMatch("aaabaaabbababaabbabaababbbbbbaabababbbaabaaaabbbbabbbbaaaaabaabbbbaaaabbabbaaabbabbbababbaaaabbabbabbbbabaabbabbbabbbbabbbbbaabbbababaaaababbbbababababababbabbbbaaaaababbaaababbabaababbbaaabbbbbababab", "aa*abab*a*a**a*b****ba*ba*aa*****b****b**bbbba*b*b*a**b**b*aab***b*bb***baa*b***a***baa*****a*a*a*ab**a"));
        assertFalse(solution.isMatch("bbbabaa", "*ba"));
        assertFalse(solution.isMatch("abaabb", "?a**"));
    }
}
