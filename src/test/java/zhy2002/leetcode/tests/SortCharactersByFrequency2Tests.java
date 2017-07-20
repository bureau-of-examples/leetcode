package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/#/description
 */
public class SortCharactersByFrequency2Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {

        public String frequencySort(String s) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (char ch : s.toCharArray()) {
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
            StringBuilder sb = new StringBuilder();
            frequency.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).forEach(
                    (e) -> {
                        for (int i = 0; i < e.getValue(); i++) {
                            sb.append(e.getKey());
                        }
                    }
            );
            return sb.toString();
        }
    }
}
