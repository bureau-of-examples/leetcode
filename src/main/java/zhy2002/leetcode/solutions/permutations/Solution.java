package zhy2002.leetcode.solutions.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/permutations/
 */
public class Solution {


    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> results = new ArrayList<>();
        if (num == null)
            return results;

        int[] indices = new int[num.length]; //permute this array
        for (int i = 0; i < indices.length; i++)
            indices[i] = i;

        int lastPos = indices.length - 1;
        int pos = lastPos;
        while (pos >= 0) {
            if (pos == lastPos) {
                results.add(createResult(indices, num)); //dump result from the permutation of indices
                pos--;
            } else {
                if (indices[pos] > indices[pos + 1]) {
                    pos--;
                } else {
                    int swapPos = binSearchFirstBigger(indices, pos + 1, lastPos);//descending order
                    swap(indices, pos, swapPos);
                    reverseAfter(indices, pos);
                    pos = lastPos;
                }
            }

        }

        return results;
    }

    private static int binSearchFirstBigger(int[] indices, int start, int end) {
        int val = indices[start - 1];
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (indices[mid] == val)
                return mid;

            if (indices[mid] > val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private static void reverseAfter(int[] indices, int pos) {
        int start = pos + 1;
        int end = indices.length - 1;
        while (start < end) {
            swap(indices, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] indices, int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    private static List<Integer> createResult(int[] indices, int[] num) {
        List<Integer> item = new ArrayList<>();
        for (int index : indices) {
            item.add(num[index]);
        }
        return item;
    }
}
