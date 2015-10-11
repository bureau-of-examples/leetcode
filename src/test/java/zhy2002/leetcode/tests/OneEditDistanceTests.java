package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.oneeditdistance.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class OneEditDistanceTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.isOneEditDistance("",""), equalTo(false));
        assertThat(solution.isOneEditDistance("a",""), equalTo(true));
        assertThat(solution.isOneEditDistance("aba","aa"), equalTo(true));
        assertThat(solution.isOneEditDistance("aba","ba"), equalTo(true));
        assertThat(solution.isOneEditDistance("aba","aa"), equalTo(true));
        assertThat(solution.isOneEditDistance("aba","aba"), equalTo(false));
        assertThat(solution.isOneEditDistance("abc","tba"), equalTo(false));
        assertThat(solution.isOneEditDistance("aace","aae"), equalTo(true));
        assertThat(solution.isOneEditDistance("aace","aac"), equalTo(true));
        assertThat(solution.isOneEditDistance("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"), equalTo(false));
        assertThat(solution.isOneEditDistance("aacrewe","aac"), equalTo(false));
        assertThat(solution.isOneEditDistance("cab","ad"), equalTo(false));
    }
}
