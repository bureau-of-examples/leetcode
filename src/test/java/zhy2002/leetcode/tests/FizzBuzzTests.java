package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/fizz-buzz/#/description
 */
public class FizzBuzzTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>();
            for (int i=1; i <=n ; i++) {
                result.add(convert(i));
            }
            return result;
        }

        private String convert(int i) {
            if (i % 15 == 0)
                return "FizzBuzz";
            if (i % 5 == 0)
                return "Buzz";
            if (i % 3 == 0)
                return "Fizz";
            return String.valueOf(i);
        }
    }

}
