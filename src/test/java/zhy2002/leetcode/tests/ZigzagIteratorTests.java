package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.zigzagiterator.ZigzagIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ZigzagIteratorTests {

    @Test
    public void basicTest() {
        ZigzagIterator iterator = new ZigzagIterator(Arrays.asList(1,3,5), Arrays.asList(2,4,6,8,10));

        String result = toList(iterator);
        assertThat(result, equalTo("1,2,3,4,5,6,8,10"));

        result = toList(new ZigzagIterator(new ArrayList<>(), Arrays.asList(1,2,3)));
        assertThat(result, equalTo("1,2,3"));

        result = toList(new ZigzagIterator(Arrays.asList(1,2,3), new ArrayList<>()));
        assertThat(result, equalTo("1,2,3"));

        result = toList(new ZigzagIterator(Arrays.asList(1,2,3), Collections.singletonList(5)));
        assertThat(result, equalTo("1,5,2,3"));
    }

    private String toList(ZigzagIterator iterator) {
        ArrayList<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add( iterator.next());
        }
        return Utils.integersToString(result);
    }
}
