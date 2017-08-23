package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindKClosestElementsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findClosestElements(Arrays.asList(0,0,0,1,3,5,6,7,8,8), 2, 2),
                equalTo(Arrays.asList(1,3))
        );

        assertThat(
                solution.findClosestElements(Arrays.asList(1, 2, 3, 4, 5), 3, -1),
                equalTo(Arrays.asList(1, 2, 3))
        );
        assertThat(
                solution.findClosestElements(Arrays.asList(1, 2, 3, 4, 5), 4, 3),
                equalTo(Arrays.asList(1, 2, 3, 4))
        );
    }

    class Solution {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            int start = 0, end = arr.size() - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (arr.get(mid) <= x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            Stack<Integer> left = new Stack<>();
            List<Integer> right = new ArrayList<>();
            while (k-- > 0) {
                if (start == arr.size() || end >= 0 && x - arr.get(end) <= arr.get(start) - x) {
                    left.push(arr.get(end--));
                } else {
                    right.add(arr.get(start++));
                }
            }
            List<Integer> result = new ArrayList<>();
            while (!left.isEmpty()) {
                result.add(left.pop());
            }
            result.addAll(right);
            return result;
        }
    }

    class Solution2 {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            int[][] counts = new int[20001][2];
            for (int num : arr) {
                int diff = x - num;
                if (diff >= 0) {
                    counts[Math.abs(diff)][0]++;
                } else {
                    counts[Math.abs(diff)][1]++;
                }
            }

            Stack<Integer> first = new Stack<>();
            List<Integer> second = new ArrayList<>();
            OUTER:
            for (int i = 0; i < counts.length; i++) {
                if (counts[i][0] + counts[i][1] == 0)
                    continue;

                while (counts[i][0]-- > 0) {
                    first.push(x - i);
                    if (--k == 0)
                        break OUTER;
                }

                while (counts[i][1]-- > 0) {
                    second.add(x + i);
                    if (--k == 0)
                        break OUTER;
                }
            }
            List<Integer> result = new ArrayList<>();
            while (!first.isEmpty()) {
                result.add(first.pop());
            }
            result.addAll(second);
            return result;
        }
    }
}
