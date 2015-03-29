package zhy2002.leetcode.solutions.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For each number, use two pointers to find they other 2.
 * To avoid duplicates we examine (i < j < k)
 */
public class TwoPointerSolution implements Solution {

    public List<List<Integer>> threeSum(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (num.length < 3)
            return result;

        // sort array
        Arrays.sort(num);
        int lastIndex = num.length - 3;
        int i = 0;
        while (i <= lastIndex) {

            int start = i + 1;
            int end = num.length - 1;
            int target = -num[i];
            while (start < end) {
                int sum2 = num[start] + num[end];
                if (sum2 == target) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(num[i]);
                    item.add(num[start]);
                    item.add(num[end]);
                    result.add(item);

                    do {
                        start++;
                    }
                    while (start < end && num[start] == num[start - 1]);
                    if (start >= end)
                        break;

                    do {
                        end--;
                    } while (end > start && num[end] == num[end + 1]);

                } else if (sum2 > target) {
                    end--;
                } else {
                    start++;
                }
            }

            do {
                i++;
            } while (i <= lastIndex && num[i] == num[i - 1]);
        }

        return result;
    }
}
