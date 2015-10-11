package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.longestsubstringwithatmosttwodistinctcharacters.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by ZHY on 10/11/2015.
 */
public class LongestSubstringWithAtMostTwoDistinctCharactersTests {

    @Test
    public void twoPointersTest(){
        basicTest(new PointerSolution());
    }

    @Test
    public void hashMapTest(){
        basicTest(new HashMapSolution());
    }

    private void basicTest(Solution solution) {

        assertThat(solution.lengthOfLongestSubstringTwoDistinct(""), equalTo(0));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("a"), equalTo(1));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("aaa"), equalTo(3));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("aaabbbb"), equalTo(7));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("aaabbbbc"), equalTo(7));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("reaaabbbbc"), equalTo(7));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("rebaaabbbbc"), equalTo(8));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("rebabaababbbac"), equalTo(11));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("rcccbbcaaaaace"), equalTo(7));
        assertThat(solution.lengthOfLongestSubstringTwoDistinct("aaaeacacacdacaccccbbbbb"), equalTo(9));

    }
}
