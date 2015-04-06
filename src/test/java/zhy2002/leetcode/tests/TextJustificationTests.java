package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.textjustification.Solution;
import static org.junit.Assert.*;

public class TextJustificationTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertEquals("abc    def ttttt bade",Utils.listToString(solution.fullJustify(new String[]{"abc", "def", "ttttt", "bade"}, 10)));
        assertEquals("This    is    an example  of text justification.  ",Utils.listToString(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)));
        assertEquals("Listen to     many,  speak  to   a few.  ",Utils.listToString(solution.fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6)));

    }
}
