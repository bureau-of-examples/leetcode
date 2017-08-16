package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/evaluate-division/description/
 */
public class EvaluateDivisionTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.calcEquation(
                        new String[][]{{"a", "b"}, {"b", "c"}},
                        new double[]{2.0, 3.0},
                        new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}}),
                equalTo(new double[]{6.0, 0.5, -1.0, 1.0, -1.0})
        );
    }

    public class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String, Map<String, Double>> lookup = build(equations, values);
            double[] result = new double[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = eval(lookup, queries[i]);
            }
            return result;
        }

        private Map<String, Map<String, Double>> build(String[][] equations, double[] values) {
            Map<String, Map<String, Double>> result = new HashMap<>();
            for (int i = 0; i < equations.length; i++) {
                String a, b;
                double r;
                if (equations[i][0].compareTo(equations[i][1]) > 0) {
                    a = equations[i][1];
                    b = equations[i][0];
                    r = 1 / values[i];
                } else {
                    a = equations[i][0];
                    b = equations[i][1];
                    r = values[i];
                }
                result.computeIfAbsent(a, k -> new HashMap<>()).put(b, r);
                result.get(a).put(a, 1d);
                result.computeIfAbsent(b, k -> new HashMap<>()).put(b, 1d);
            }
            return result;
        }

        private double eval(Map<String, Map<String, Double>> lookup, String[] query) {
            String a, b;
            boolean inverse;
            if (query[0].compareTo(query[1]) > 0) {
                a = query[1];
                b = query[0];
                inverse = true;
            } else {
                a = query[0];
                b = query[1];
                inverse = false;
            }
            Map<String, Double> table = lookup.get(a);
            if (table == null)
                return -1; //unknown variable
            Double result = table.get(b);
            if (result == null) {
                table.put(b, -1d); //break circle
                for (String common : lookup.keySet()) {
                    double first = eval(lookup, new String[]{a, common});
                    if (first == -1)
                        continue;
                    double second = eval(lookup, new String[]{common, b});
                    if (second == -1)
                        continue;
                    result = first * second;
                }
                if (result == null) {
                    result = -1d;
                }
                table.put(b, result);
            }
            return inverse ? 1 / result : result;
        }
    }

}
