package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.substringwithconcatenationofallwords.Solution;

import java.util.List;

import static org.junit.Assert.*;

public class SubstringWithConcatenationOfAllWordsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        List<Integer> result = solution.findSubstring("thebuypietop", new String[]{"buy", "pie"});
        assertEquals("3", Utils.integersToString(result));

        result = solution.findSubstring("thebuypietop", new String[]{"buy", "pie", "top"});
        assertEquals("3", Utils.integersToString(result));

        result = solution.findSubstring("thebuypietopbuy", new String[]{"buy", "pie", "top"});
        assertEquals("3,6", Utils.integersToString(result));

        result = solution.findSubstring("buypietopbuythe", new String[]{"buy", "pie", "top"});
        assertEquals("0,3", Utils.integersToString(result));

        result = solution.findSubstring("butbuypietopbuythe", new String[]{"buy", "pie", "top"});
        assertEquals("3,6", Utils.integersToString(result));

        result = solution.findSubstring("butbuypietopsixbuythe", new String[]{"buy", "pie", "top"});
        assertEquals("3", Utils.integersToString(result));

        result = solution.findSubstring("butbuybuypiebuybuytopsixbuythe", new String[]{"buy", "pie", "top"});
        assertEquals("", Utils.integersToString(result));

        result = solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        assertEquals("0,9", Utils.integersToString(result));

        result = solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"});
        assertEquals("13", Utils.integersToString(result));

        result = solution.findSubstring("abababab", new String[]{"ab", "ba"});
        assertEquals("", Utils.integersToString(result));

        result = solution.findSubstring("ccbbdc", new String[]{"bd", "cb"});
        assertEquals("1", Utils.integersToString(result));
    }
}
