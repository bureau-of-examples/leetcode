package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/expression-add-operators/description/
 */
public class ExpressionAddOperatorsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.addOperators("105", 5),
                equalTo(Arrays.asList("1*0+5", "10-5"))
        );
        assertThat(
                solution.addOperators("00", 0),
                equalTo(Arrays.asList("0+0", "0-0", "0*0"))
        );
        assertThat(
                solution.addOperators("232", 8),
                equalTo(Arrays.asList("2+3*2", "2*3+2"))
        );
        assertThat(
                solution.addOperators("123", 6),
                equalTo(Arrays.asList("1+2+3", "1*2*3"))
        );
    }

    public class Solution {
        private String num;
        private int target;
        private List<String> result;

        public List<String> addOperators(String num, int target) {
            this.num = num;
            this.target = target;
            result = new ArrayList<>();
            populate("", 0, 0, 0);
            return result;
        }

        private void populate(String prefix, int pos, long prefixVal, long mulTermVal) {
            if (pos == num.length()) {
                if (prefixVal == target) {
                    result.add(prefix);
                }
                return;
            }
            for (int nextStart = pos + 1; nextStart <= num.length(); nextStart++) {
                int len = nextStart - pos;
                if (num.charAt(pos) == '0' && len > 1)
                    break;
                String str = num.substring(pos, nextStart);
                long val = Long.parseLong(str);
                if (pos == 0) {
                    populate(str, nextStart, val, val);
                } else {
                    populate(prefix + "+" + str, nextStart, prefixVal + val, val);
                    populate(prefix + "-" + str, nextStart, prefixVal - val, -val);
                    populate(prefix + "*" + str, nextStart, prefixVal - mulTermVal + mulTermVal * val, mulTermVal * val);
                }
            }
        }
    }

}
