package zhy2002.leetcode.tests;

import java.util.*;

/**
 * https://leetcode.com/problems/keyboard-row/#/description
 */
public class KeyboardRowTests {

    public class Solution {
        private List<Set<Character>> rows = new ArrayList<>();

        public Solution() {
            rows.add(new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p')));
            rows.add(new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l')));
            rows.add(new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm')));
        }

        public String[] findWords(String[] words) {
            List<String> good = new ArrayList<>();
            for (String word : words) {
                if (isGood(word)) {
                    good.add(word);
                }
            }
            return good.toArray(new String[good.size()]);
        }

        private boolean isGood(String word) {
            String lower = word.toLowerCase();
            Set<Integer> r = new HashSet<>();
            for (int i = 0; i < lower.length(); i++) {
                char ch = word.charAt(i);
                for (int j = 0; j < rows.size(); j++) {
                    if (rows.get(j).contains(ch)) {
                        r.add(j);
                        break;
                    }
                }
                if (r.size() > 1)
                    return false;
            }
            return true;
        }
    }
}
