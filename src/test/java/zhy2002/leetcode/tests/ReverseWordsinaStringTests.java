package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.reversewordsinastring.Solution;

import static org.junit.Assert.*;
/**
 * Created by ZHY on 21/02/2015.
 */
public class ReverseWordsInAStringTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals("", solution.reverseWords(""));
        assertEquals("Sentence", solution.reverseWords("Sentence"));
        assertEquals("word", solution.reverseWords("   word   "));
        assertEquals("second first", solution.reverseWords("first  second"));
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
        assertEquals("Saturday. is Today", solution.reverseWords("Today is Saturday."));
    }
}
