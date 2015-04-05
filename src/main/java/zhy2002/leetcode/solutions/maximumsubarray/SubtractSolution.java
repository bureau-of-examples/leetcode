package zhy2002.leetcode.solutions.maximumsubarray;

/**
 * Linear solution based on this equation:
 * Sum(i, j) = SumTo(j) - SumTo(i-1)
 */
public class SubtractSolution implements Solution {

    @Override
    public int maxSubArray(int[] A) {
        int sumA = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            sumA += A[i];
            int maxI = sumA - minSum;
            if(maxI > max){
                max = maxI;
            }
            if(sumA < minSum){
                minSum = sumA;
            }
        }
        return max;
    }
}
