package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.shortestworddistanceii.WordDistance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShortestWordDistanceIITests {

    @Test
    public void basicTest(){

        WordDistance wordDistance = new WordDistance(new String[]{"A", "B", "C", "D", "B", "E", "K", "A", "F"});

        assertThat(wordDistance.shortest("A", "B"), equalTo(1));
        assertThat(wordDistance.shortest("B", "K"), equalTo(2));
        assertThat(wordDistance.shortest("C", "E"), equalTo(3));
        assertThat(wordDistance.shortest("C", "D"), equalTo(1));
        assertThat(wordDistance.shortest("E", "A"), equalTo(2));
        assertThat(wordDistance.shortest("F", "B"), equalTo(4));


        wordDistance = new WordDistance(new String[]{"A", "C", "C", "B", "B", "B", "C", "A", "A", "B", "B", "C", "C"});
        assertThat(wordDistance.shortest("A", "B"), equalTo(1));
        assertThat(wordDistance.shortest("C", "B"), equalTo(1));
    }
}
