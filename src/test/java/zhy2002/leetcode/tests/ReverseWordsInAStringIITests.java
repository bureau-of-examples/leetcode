package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import zhy2002.leetcode.solutions.reversewordsinastringii.Solution;


public class ReverseWordsInAStringIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        char[] input = "the sky is blue".toCharArray();
        solution.reverseWords(input);
        assertThat(new String(input),equalTo( "blue is sky the"));

        input = "this is a test".toCharArray();
        solution.reverseWords(input);
        assertThat(new String(input),equalTo( "test a is this"));

    }
}
