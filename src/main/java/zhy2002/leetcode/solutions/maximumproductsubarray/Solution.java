package zhy2002.leetcode.solutions.maximumproductsubarray;

/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 * For each element A[i], calculate the max product of all subarray that end at i.
 * max_prod(i) =
 * A[i] == 0 => 0
 * A[i] >  0, max_prod(i-1) > 0 -> A[i] * max_prod(i-1) -> max(A[i] * max_prod(i-1), A[i])
 * A[i] >  0, max_prod(i-1) <=0 -> A[i]                 -> max(A[i] * max_prod(i-1), A[i])
 * A[i] <  0, min_prod(i-1) < 0 -> A[i] * min_prod(i-1) -> min(A[i] * min_prod(i-1), A[i])
 * A[i] <  0, min_prod(i-1) >=0 -> A[i]                 -> min(A[i] * min_prod(i-1), A[i])
 *
 * Similarly we can solve min_prod(i).
 */
public class Solution {

    public int maxProduct(int[] A) {
        if(A == null || A.length == 0)
            return 0;

        int maxHere = A[0];
        int minHere = maxHere;
        int max = maxHere;

        for(int i=1;i<A.length;i++){
            int newMaxHere;
            if(A[i] >= 0){
                newMaxHere = Math.max(A[i], A[i]*maxHere);
                minHere = Math.min(A[i], A[i]*minHere);
            } else {
                newMaxHere = Math.max(A[i], A[i]*minHere);
                minHere = Math.min(A[i], A[i]*maxHere);
            }
            maxHere = newMaxHere;
            if(maxHere > max)
                max = maxHere;
        }
        return max;
    }
}
