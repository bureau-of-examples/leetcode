package zhy2002.leetcode.solutions.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For each i < j run two pointers to find the other two numbers.
 * The time complexity is O(N^3).
 */
public class TwoPointersSolution implements Solution {

    @Override
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(num);
        int lastI = num.length - 4;
        int lastJ = num.length - 3;
        for (int i = 0; i <= lastI; i++) {
            if (i != 0 && num[i] == num[i - 1])
                continue;

            for (int j = i + 1; j <= lastJ; j++) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;

                //two sum logic
                int subTarget = target - (num[i] + num[j]);
                int start = j + 1, end = num.length - 1;
                while (start < end) {
                    //avoid duplicates
                    if (start != j + 1 && num[start] == num[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end != num.length - 1 && num[end] == num[end + 1]) {
                        end--;
                        continue;
                    }

                    int sumLatterTwo = num[start] + num[end];
                    if (sumLatterTwo == subTarget) {
                        result.add(Arrays.asList(num[i], num[j], num[start], num[end]));
                        start++;
                        end--;
                    } else if (sumLatterTwo > subTarget) {
                        end--;

                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
