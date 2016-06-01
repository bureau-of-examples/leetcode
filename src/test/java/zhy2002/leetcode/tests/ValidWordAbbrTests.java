package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.validwordabbr.ValidWordAbbr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidWordAbbrTests {

    @Test
    public void basicTest() {

        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        assertThat(validWordAbbr.isUnique("dear"), equalTo(false));
        assertThat(validWordAbbr.isUnique("door"), equalTo(false));
        assertThat(validWordAbbr.isUnique("cake"), equalTo(true));
        assertThat(validWordAbbr.isUnique("coke"), equalTo(false));

        validWordAbbr = new ValidWordAbbr(new String[]{"dog", "dog"});
        assertThat(validWordAbbr.isUnique("dog"), equalTo(true));
        assertThat(validWordAbbr.isUnique("dig"), equalTo(false));

        validWordAbbr = new ValidWordAbbr(new String[0]);
        assertThat(validWordAbbr.isUnique("Hello"), equalTo(true));

        validWordAbbr = new ValidWordAbbr(new String[]{"a", "b"});
        assertThat(validWordAbbr.isUnique("a"), equalTo(true));
        assertThat(validWordAbbr.isUnique("c"), equalTo(true));

    }
}
