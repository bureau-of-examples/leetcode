package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/gray-code/#/description
 */
public class GrayCode2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.grayCode(1), equalTo(Arrays.asList(0, 1)));
    }

    public class Solution {
        public List<Integer> grayCode(int n) {
            int[] lastBit = {0, 1, 1, 0};
            List<Integer> result = new ArrayList<>();
            result.add(0);
            for (int i = 1; i <= n; i++) {
                List<Integer> newResult = new ArrayList<>();
                for (int code : result) {
                    newResult.add(code << 1 | lastBit[newResult.size() % 4]);
                    newResult.add(code << 1 | lastBit[newResult.size() % 4]);
                }
                result = newResult;
            }
            return result;
        }
    }

}
