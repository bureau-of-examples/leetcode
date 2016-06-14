package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.encodeanddecodestrings.Codec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EncodeAndDecodeStringsTest {

    @Test
    public void basicTest() {
        Codec codec = new Codec();

        String encoded = codec.encode(Collections.emptyList());
        assertThat(encoded, equalTo("[]"));

        encoded = codec.encode(Collections.singletonList("test"));
        assertThat(encoded, equalTo("[\"test\"]"));

        List<String> input = Collections.singletonList("\"test\"");
        encoded = codec.encode(input);
        assertThat(encoded, equalTo("[\"\"\"test\"\"\"]"));
        List<String> decoded = codec.decode("[\"\"\"test\"\"\"]");
        assertThat(decoded, equalTo(input));

        input = Arrays.asList("\"", "\"");
        assertThat(codec.decode(codec.encode(input)), equalTo(input));

        input = Arrays.asList("\"", "\"", "\"test");
        assertThat(codec.decode(codec.encode(input)), equalTo(input));

        input = Arrays.asList("\"", "test\"", "\"test");
        assertThat(codec.decode(codec.encode(input)), equalTo(input));

    }
}
