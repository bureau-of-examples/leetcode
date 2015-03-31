package zhy2002.leetcode.solutions.removeduplicatesfromsortedarray;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * The first k elements form a sub-list which contains no duplicates.
 */
public class Solution {

    public int removeDuplicates(int[] A) {
        if(A == null)
            return 0;

        if(A.length <= 1)
            return A.length;

        int len = 1;
        for(int i=1; i< A.length; i++){
            if(A[i] != A[len - 1]){
                if(i != len){
                    int temp = A[len];
                    A[len] = A[i];
                    A[i] = temp;
                }
                len++;
            }
        }

        return len;
    }

}
