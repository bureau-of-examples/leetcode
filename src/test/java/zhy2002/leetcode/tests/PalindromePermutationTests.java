package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.palindromepermutation.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PalindromePermutationTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertThat(solution.canPermutePalindrome("a"), equalTo(true));
        assertThat(solution.canPermutePalindrome("ab"), equalTo(false));
        assertThat(solution.canPermutePalindrome("carerac"), equalTo(true));
        assertThat(solution.canPermutePalindrome("aab"), equalTo(true));
        assertThat(solution.canPermutePalindrome("code"), equalTo(false));
    }
}
