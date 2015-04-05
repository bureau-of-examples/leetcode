package zhy2002.leetcode.solutions.firstmissingpositive;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Because there are only n elements in the array, the missing integer must be in the range of [1, n+1].
 * We rearrange the values (sort) in A, so that we put value i+1 at index i.
 */
public class Solution {

    public int firstMissingPositive(int[] A) {
        //in-place bucket sort
        for(int i=0; i < A.length; i++){
            while(A[i] != i+1) {
                if(A[i] - 1 < 0 || A[i] - 1 >= A.length || A[A[i] - 1] == A[i])//got it
                    break;
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];//put A[i] where it belongs
                A[i] = temp;
            }
        }

        for(int i=0; i<A.length; i++){
            if(A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;

    }

}
