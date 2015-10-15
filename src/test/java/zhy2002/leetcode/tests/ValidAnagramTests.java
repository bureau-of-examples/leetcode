package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.validanagram.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ValidAnagramTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertThat(solution.isAnagram("", ""), equalTo(true));
        assertThat(solution.isAnagram("abc", "cba"), equalTo(true));
        assertThat(solution.isAnagram("aabbc", "babca"), equalTo(true));
        assertThat(solution.isAnagram("aadef", "fcbba"), equalTo(false));
        assertThat(solution.isAnagram("ttttt", "ttttt"), equalTo(true));
        assertThat(solution.isAnagram("babababa", "abababab"), equalTo(true));
        assertThat(solution.isAnagram("aafdafdas", "re"), equalTo(false));
    }
}
