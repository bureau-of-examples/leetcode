package zhy2002.leetcode.solutions.maximumsubarray;

/**
 * Divide and Conquer solution O(n log n).
 */
public class DNCSolution implements Solution {


    @Override
    public int maxSubArray(int[] A) {
        return maxSubArray(A, 0, A.length);
    }

    private int maxSubArray(int[] A, int start, int end/*exclusive*/){
        if(end - start == 1)
            return A[start];

        int mid = start + (end - start) / 2;
        int crossLeft = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid-1; i>=start; i--){
            sum += A[i];
            if(sum > crossLeft){
                crossLeft = sum;
            }
        }

        int crossRight = Integer.MIN_VALUE;
        sum = 0;
        for(int i=mid; i<end; i++){
            sum += A[i];
            if(sum > crossRight){
                crossRight = sum;
            }
        }
        int maxCross = crossLeft + crossRight;
        int maxLeft = maxSubArray(A, start, mid);
        int maxRight = maxSubArray(A, mid, end);
        return Math.max(maxCross, Math.max(maxLeft, maxRight));
    }
}
