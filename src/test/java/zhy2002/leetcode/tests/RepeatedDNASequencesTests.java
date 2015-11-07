package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.repeateddnasequences.Solution;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RepeatedDNASequencesTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        List<String> results = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertThat(results, equalTo(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA")));

        results = solution.findRepeatedDnaSequences("AAAAAAAAAAA");
        assertThat(results, equalTo(Arrays.asList("AAAAAAAAAA")));

        results = solution.findRepeatedDnaSequences("CAAAACAAAACAAAA");
        assertThat(results, equalTo(Arrays.asList("CAAAACAAAA")));

        results = solution.findRepeatedDnaSequences("CAAAACAAAACAAAACAAAA");
        assertThat(results, equalTo(Arrays.asList("CAAAACAAAA", "AAAACAAAAC", "AAACAAAACA", "AACAAAACAA", "ACAAAACAAA")));


    }
}
