package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.ransomnote.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RansomNoteTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.canConstruct("", ""), equalTo(true));
        assertThat(solution.canConstruct("a", "b"), equalTo(false));
        assertThat(solution.canConstruct("aa", "ab"), equalTo(false));
        assertThat(solution.canConstruct("aa", "aab"), equalTo(true));
        assertThat(solution.canConstruct("aabbbc", "acabcabeb"), equalTo(true));
        assertThat(solution.canConstruct("testabca", "audittcsbf"), equalTo(false));
        assertThat(solution.canConstruct("zzzeeabb", "zzaaebebcczddee"), equalTo(true));
    }
}
