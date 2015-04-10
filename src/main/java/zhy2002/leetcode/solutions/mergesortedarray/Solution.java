package zhy2002.leetcode.solutions.mergesortedarray;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Solution {

    public void merge(int A[], int m, int B[], int n) {

        if(A == null || B == null)
            return;

        if(A.length < m + n || B.length < n || m < 0 || n < 0)
            throw new IllegalArgumentException();

        int indexA = m - 1;
        int indexB = n - 1;

        for(int i = m + n - 1; i>=0; i--){
            if(indexB < 0){
                break;
            }

            if(indexA < 0){
                while (i >= 0){
                    A[i--] = B[indexB--];
                }
                break;
            }

            if(A[indexA] < B[indexB]){
                A[i] = B[indexB--];
            } else {
                A[i] = A[indexA--];
            }
        }
    }


}
