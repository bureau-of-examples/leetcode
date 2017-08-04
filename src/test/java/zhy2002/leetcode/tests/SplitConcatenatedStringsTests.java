package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/split-concatenated-strings/solution/
 */
public class SplitConcatenatedStringsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.splitLoopedString(new String[]{"abc", "xyz"}), equalTo("zyxcba"));
    }

    public class Solution {

        public String splitLoopedString(String[] strs) {
            if (strs.length == 0)
                return "";
            String[] reverseStrs = new String[strs.length];
            for (int i = 0; i < strs.length; i++) {
                String reverse = new StringBuilder(strs[i]).reverse().toString();
                if (strs[i].compareTo(reverse) < 0) {
                    reverseStrs[i] = strs[i];
                    strs[i] = reverse;
                } else {
                    reverseStrs[i] = reverse;
                }
            }

            String max = null; //try all the ways to break look
            for (int i = 0; i < strs.length; i++) {
                for (String str : new String[]{strs[i], reverseStrs[i]}) {
                    for (int j = 0; j < str.length(); j++) {
                        if (max != null && str.charAt(j) < max.charAt(0))
                            continue;
                        StringBuilder cutLoop = new StringBuilder();
                        cutLoop.append(str.substring(j));
                        for (int k = i + 1; k < strs.length; k++) {
                            cutLoop.append(strs[k]);
                        }
                        for (int k = 0; k < i; k++) {
                            cutLoop.append(strs[k]);
                        }
                        cutLoop.append(str.substring(0, j));
                        String cutLoopStr = cutLoop.toString();
                        if (max == null || max.compareTo(cutLoopStr) < 0) {
                            max = cutLoopStr;
                        }
                    }
                }
            }

            return max;
        }
    }
}
