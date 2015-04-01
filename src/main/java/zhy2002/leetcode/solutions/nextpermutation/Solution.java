package zhy2002.leetcode.solutions.nextpermutation;

/**
 * https://leetcode.com/problems/next-permutation/
 * A permutation of n integers, can be seen as a big number.
 * Next permutation is the next bigger number formed by the same numbers.
 */
public class Solution {

    public void nextPermutation(int[] num) {

        int tailDescStart = num.length - 1;
        while (tailDescStart > 0 && num[tailDescStart - 1] >= num[tailDescStart])
            tailDescStart--;
        if (tailDescStart == 0) {//reverse order
            reverse(num, 0, num.length - 1);
            return;
        }

        int increasePos = tailDescStart - 1;
        //bin search first bigger in range [tailDescStart, num.length - 1], which is in non-ascending order
        int start = tailDescStart, end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (num[mid] <= num[increasePos]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        swap(num, increasePos, end);
        reverse(num, increasePos + 1, num.length - 1);
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private static void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }

}
