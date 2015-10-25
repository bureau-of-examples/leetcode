package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.palindromelinkedlist.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PalindromeLinkedListTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.isPalindrome(Utils.createLinkedList()), equalTo(true));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1)), equalTo(true));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,1)), equalTo(true));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,1)), equalTo(true));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2)), equalTo(false));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,2)), equalTo(false));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,2,1)), equalTo(true));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,4,1)), equalTo(false));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,3,2,1)), equalTo(true));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,3,4,2,1)), equalTo(false));
        assertThat(solution.isPalindrome(Utils.createLinkedList(1,2,3,4,3,1,1)), equalTo(false));
    }
}
