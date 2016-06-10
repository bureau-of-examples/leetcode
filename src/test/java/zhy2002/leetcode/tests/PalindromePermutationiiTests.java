package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.palindromepermutationii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class PalindromePermutationiiTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        List<String> results = solution.generatePalindromes("");
        assertThat(results, hasSize(1));

        results = solution.generatePalindromes("ab");
        assertThat(results, hasSize(0));

        results = solution.generatePalindromes("abc");
        assertThat(results, hasSize(0));

        results = solution.generatePalindromes("a");
        assertThat(results, hasSize(1));

        results = solution.generatePalindromes("aa");
        assertThat(results, hasSize(1));

        results = solution.generatePalindromes("aab");
        assertThat(results, hasSize(1));

        results = solution.generatePalindromes("aabb");
        assertThat(results, hasSize(2));

        results = solution.generatePalindromes("abab");
        assertThat(results, hasSize(2));

        results = solution.generatePalindromes("acbab");
        assertThat(results, hasSize(2));

        results = solution.generatePalindromes("acbabbb");
        assertThat(results, hasSize(3));

        results = solution.generatePalindromes("abcabc");
        assertThat(results, hasSize(6));

        results = solution.generatePalindromes("aaaaaa");
        assertThat(results, hasSize(1));
    }
}
