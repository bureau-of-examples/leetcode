package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/#/description
 */
public class SortCharactersByFrequencyTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            Map<Character, Integer> indices = new HashMap<>();

            int index = 0;
            for (char ch : s.toCharArray()) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
                indices.putIfAbsent(ch, index++);
            }

            StringBuilder sb = new StringBuilder();
            List<Map.Entry<Character, Integer>> entries = counts.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int comp = e2.getValue() - e1.getValue();
                        if (comp == 0) {
                            comp = indices.get(e1.getKey()) - indices.get(e2.getKey());
                        }
                        return comp;
                    }).collect(Collectors.toList());
            for (Map.Entry<Character, Integer> entry : entries) {
                repeat(sb, entry.getKey(), entry.getValue());
            }
            return sb.toString();
        }

        private void repeat(StringBuilder sb, Character ch, int count) {
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }
    }
}
