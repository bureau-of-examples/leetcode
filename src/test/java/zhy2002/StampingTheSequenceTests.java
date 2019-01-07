package zhy2002;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StampingTheSequenceTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        int[] result = solution.movesToStamp("abc", "ababc");
        for (int val : result) {
            System.out.println(val);
        }
    }

    class Solution {
        public int[] movesToStamp(String stamp, String target) {
            final int index = target.indexOf(stamp);
            if (index < 0) {
                return new int[0];
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(index);
            char[] t = target.toCharArray();
            char[] s = stamp.toCharArray();
            for (int i=0; i<s.length; i++) {
                t[index + i] = '*';
            }
            if (!matchForward(t, s, index + 1, tmp) || !matchBackward(t, s, index - 1, tmp)) {
                return new int[0];
            }

            Collections.reverse(tmp);
            int[] ret = new int[tmp.size()];
            for (int i=0; i<tmp.size(); i++) {
                ret[i] = tmp.get(i);
            }
            return ret;
        }

        private boolean matchBackward(char[] t, char[] s, int index, List<Integer> result) {
            int i = index;
            for (; i>=0; i--) {
                if (matches(t, i, s)) {
                    int start = i;
                    while (t[start] != '*') {
                        t[start++] = '*';
                    }
                    result.add(i);
                } else if (t[i + s.length - 1] != '*') {
                    break;
                }
            }

            return i < 0;
        }

        private boolean matchForward(char[] t, char[] s, int index, List<Integer> result) {
            int lastIndex = t.length - s.length;
            int i=index;
            for (; i<= lastIndex; i++) {
                if (matches(t, i, s)) {
                    int end = i + s.length - 1;
                    while(t[end] != '*') {
                        t[end--] = '*';
                    }
                    result.add(i);
                } else if (t[i] != '*') {
                    break;
                }
            }

            return i > lastIndex;
        }

        private boolean matches(char[] t, int start, char[] s) {
            for (int i=0; i<s.length; i++) {
                if (t[start + i] != s[i] && t[start + i] != '*') {
                    return false;
                }
            }
            return true;
        }
    }
}
