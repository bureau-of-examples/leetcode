package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/24-game/description/
 */
public class TwentyFourGameTests {

    public static class Solution {
        public boolean judgePoint24(int[] nums) {
            List<Double> list = new ArrayList<>();
            for (int num : nums) {
                list.add((double) num);
            }
            return solve(list);
        }

        private boolean solve(List<Double> list) {
            if (list.size() == 1)
                return Math.abs(list.get(0) - 24d) < 0.000001;

            for (int i = 0; i < list.size() - 1; i++) {
                double val1 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    double val2 = list.get(j);

                    List<Double> rest = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k == i || k == j)
                            continue;
                        rest.add(list.get(k));
                    }

                    rest.add(val1 + val2);
                    if (solve(rest))
                        return true;
                    rest.remove(rest.size() - 1);

                    rest.add(val1 - val2);
                    if (solve(rest))
                        return true;
                    rest.remove(rest.size() - 1);

                    rest.add(val2 - val1);
                    if (solve(rest))
                        return true;
                    rest.remove(rest.size() - 1);

                    rest.add(val2 * val1);
                    if (solve(rest))
                        return true;
                    rest.remove(rest.size() - 1);

                    if (val1 != 0) {
                        rest.add(val2 / val1);
                        if (solve(rest))
                            return true;
                        rest.remove(rest.size() - 1);
                    }

                    if (val2 != 0) {
                        rest.add(val1 / val2);
                        if (solve(rest))
                            return true;
                        rest.remove(rest.size() - 1);
                    }

                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.judgePoint24(new int[]{1, 3, 4, 6}),
                equalTo(true)
        );
    }

}
